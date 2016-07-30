package fr.pinguet62.pokemongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.api.dto.PokemonDto;

/**
 * Save history to don't send same information after each scheduling.
 *
 * @see PokemonDto#getUid()
 */
@Component
public class Cache {

    private final List<PokemonDto> meets = new ArrayList<>();

    public void add(PokemonDto pokemonDto) {
        meets.add(pokemonDto);
        clearOlds();
    }

    private void clearOlds() {
        meets.removeIf(pokemonDto -> pokemonDto.getExpiration_time().before(new Date()));
    }

    public boolean contains(PokemonDto pokemonDto) {
        return meets.contains(pokemonDto);
    }

}