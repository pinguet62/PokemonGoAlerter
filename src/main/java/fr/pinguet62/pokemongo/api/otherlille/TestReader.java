package fr.pinguet62.pokemongo.api.otherlille;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.api.Reader;
import fr.pinguet62.pokemongo.api.otherlille.dto.PokemonDto;
import fr.pinguet62.pokemongo.api.otherlille.dto.ResultDto;
import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.model.Pokemon;
import fr.pinguet62.pokemongo.model.Position;

/**
 * Scan only Lille.
 *
 * @see <a href="http://91.121.136.137:5004/">Web site</a>
 */
@Component
public class TestReader implements Reader {

    /**
     * Convert data from DTO to application model.
     *
     * @param dto The {@link PokemonDto}.
     * @return The {@link Appearance}.
     */
    private static Appearance dtoToModel(PokemonDto dto) {
        return new Appearance(Pokemon.fromId(dto.getPokemon_id()), new Position(dto.getLatitude(), dto.getLongitude()),
                dto.getDisappear_time());
    }

    @Override
    public List<Appearance> get(Position position) {
        // @formatter:off
        return ClientBuilder.newClient()
                .target("http://lillepokemap.ddns.net")
                    .path("raw_data")
                        .queryParam("pokemon", true)
                        .queryParam("pokestops", false)
                        .queryParam("gyms", false)
                        .queryParam("scanned", false)
                        // Rectangle
                        .queryParam("swLat", position.getLatitude() - getInterval())
                        .queryParam("swLng", position.getLongitude() - getInterval())
                        .queryParam("neLat", position.getLatitude() + getInterval())
                        .queryParam("neLng", position.getLongitude() + getInterval())
                .request()
                    .get(ResultDto.class)
                        .getPokemons().stream()
                            .map(TestReader::dtoToModel)
                            .collect(toList());
        // @formatter:on
    }

    @Override
    public double getInterval() {
        return 0.1; // Large interval to scan all Lille once
    }

}