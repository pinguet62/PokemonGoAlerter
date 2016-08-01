package fr.pinguet62.pokemongo.api.mock;

import static fr.pinguet62.pokemongo.Configuration.SCAN_RADIUS_DEGREE;
import static java.lang.Math.random;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.getInstance;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.api.Reader;
import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.model.Pokemon;
import fr.pinguet62.pokemongo.model.Position;

/** A {@link Reader} used for testing: return random {@link Appearance}. */
@Component
@Primary
public class RandomReader implements Reader {

    @Override
    public List<Appearance> get(Position centerPosition) {
        Pokemon pokemon = Pokemon.values()[(int) (random() * Pokemon.values().length)];

        Position position = new Position(random() * SCAN_RADIUS_DEGREE + centerPosition.getLatitude(),
                random() * SCAN_RADIUS_DEGREE + centerPosition.getLatitude());

        Calendar calendar = getInstance();
        calendar.add(MINUTE, (int) (15 * random()));
        calendar.add(SECOND, (int) (60 * random()));
        Date expiration = calendar.getTime();

        return range(0, (int) (10 * random())).mapToObj(x -> new Appearance(pokemon, position, expiration))
                .collect(toList());
    }

}