package fr.pinguet62.pokemongo.test;

import static fr.pinguet62.pokemongo.model.Position.distance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pinguet62.pokemongo.Program;
import fr.pinguet62.pokemongo.api.WebserviceClient;
import fr.pinguet62.pokemongo.api.dto.PokemonDto;
import fr.pinguet62.pokemongo.model.Position;

/** Calcul du rayon moyen de scan de l'API. */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Program.class)
public class Calibrator {

    private static void eachIntervalle(Position x, Position y, int nb, Consumer<Position> consumer) {
        for (int i = 0; i <= nb; i++) {
            double latitude = x.getLatitude() + i * (y.getLatitude() - x.getLatitude()) / nb;
            double longitude = x.getLongitude() + i * (y.getLongitude() - x.getLongitude()) / nb;
            consumer.accept(new Position(latitude, longitude));
        }
    }

    private static double maxRadius(List<PokemonDto> pokemons, Position currentPosition) {
        return pokemons.stream().map(pokemon -> new Position(pokemon.getLatitude(), pokemon.getLongitude()))
                .mapToDouble(position -> distance(currentPosition, position)).max().getAsDouble();
    }

    @Inject
    private WebserviceClient client;

    @Test
    public void test_echantillon() {
        int nb = 10;
        // Londre
        // Position x = new Position(51.5091698216777, -0.21097183227539062);
        // Position y = new Position(51.5091698216777, -0.012531280517578125);
        // Lille
        Position x = new Position(50.65005912218796, 3.0597782135009766);
        Position y = new Position(50.62164256763707, 3.0344581604003906);

        List<Double> values = new ArrayList<>();
        eachIntervalle(x, y, nb, position -> {
            List<PokemonDto> pokemons = client.getData(position).getPokemon();
            double distanceMax = maxRadius(pokemons, position);
            values.add(distanceMax);
        });
        values.stream().forEach(System.out::println);
        System.out.println("AVG: " + values.stream().mapToDouble(Double::doubleValue).average().getAsDouble()); // Rayon
                                                                                                                // moyen
                                                                                                                // de
                                                                                                                // 1km
    }
}