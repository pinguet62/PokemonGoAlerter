package fr.pinguet62.pokemongo.preferencies;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.Filter;
import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.model.Pokemon;

/** {@link Filter#test(Appearance) Check} if {@link Pokemon} is in <code>include</code> list. */
@Component
public class IncludedPokemonFilter implements Filter {

    @Value("#{'${pokemon.included}'.split(',')}")
    private List<Integer> pokemonNumbers;

    @Override
    public boolean test(Appearance appearance) {
        return pokemonNumbers.contains(appearance.getPokemon().getId());
    }

}