package fr.pinguet62.pokemongo;

import static fr.pinguet62.pokemongo.config.Configuration.COORDINATES_INTERVAL;
import static java.lang.Math.sqrt;
import static org.slf4j.LoggerFactory.getLogger;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.alerter.Message;
import fr.pinguet62.pokemongo.alerter.send.Sender;
import fr.pinguet62.pokemongo.api.WebserviceClient;
import fr.pinguet62.pokemongo.api.dto.PokemonDto;
import fr.pinguet62.pokemongo.api.dto.ResultDto;
import fr.pinguet62.pokemongo.config.Preferencies;
import fr.pinguet62.pokemongo.model.Pokemon;
import fr.pinguet62.pokemongo.model.Position;
import fr.pinguet62.pokemongo.model.Zone;

@Component
@EnableScheduling
public class Task {

    private static final Logger LOGGER = getLogger(Task.class);

    @Inject
    private Cache cache;

    @Inject
    private WebserviceClient client;

    @Inject
    private Preferencies preferencies;

    @Inject
    private Sender sender;

    @Scheduled(fixedDelay = 10_000)
    public void check2() {
        LOGGER.info("New schedule...");
        Zone.crissCross(preferencies.getZones(), sqrt(2) * COORDINATES_INTERVAL, pos -> {
            ResultDto result = client.getData(pos);
            if (result.getPokemon().isEmpty())
                LOGGER.debug("... no result!");

            for (PokemonDto pokemonDto : result.getPokemon()) {
                Pokemon pokemon = Pokemon.fromId(pokemonDto.getPokemonId());
                if (pokemon.getImportance().compareTo(preferencies.getMinimumLevel()) < 0) // Filter: only importants
                    continue;

                Position position = new Position(pokemonDto.getLatitude(), pokemonDto.getLongitude());

                if (cache.contains(pokemonDto)) // Filter: single notification
                    continue;
                cache.add(pokemonDto);

                // Sub-zone
                Zone subZone = preferencies.getZones().stream().filter(z -> z.contains(position)).findFirst()
                        .orElse(null);
                if (subZone == null) // Filter: personal zone
                    continue;

                Message message = new Message(pokemon, subZone, pokemonDto.getExpiration_time(), position);
                sender.send(message);
            }
        });
    }

}