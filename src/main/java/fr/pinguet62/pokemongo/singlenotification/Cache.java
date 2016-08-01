package fr.pinguet62.pokemongo.singlenotification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.model.Appearance;

/** Save history to don't send same information after each scheduling. */
@Component
public class Cache {

    private final List<Appearance> meets = new ArrayList<>();

    public void add(Appearance pokemonDto) {
        meets.add(pokemonDto);
        clearOlds();
    }

    private void clearOlds() {
        meets.removeIf(appearance -> appearance.getExpiration().before(new Date()));
    }

    /** @see List#contains(Object) */
    public boolean contains(Appearance pokemonDto) {
        return meets.contains(pokemonDto);
    }

}