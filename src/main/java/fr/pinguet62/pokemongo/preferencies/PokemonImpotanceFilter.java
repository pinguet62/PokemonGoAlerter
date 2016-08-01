package fr.pinguet62.pokemongo.preferencies;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.Filter;
import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.model.Pokemon;

/**
 * {@link Filter#test(Appearance) Check} if {@link Pokemon#getImportance() pokemon importance} is greater than
 * {@link Preferencies#getMinimumLevel()}.
 *
 * @see Preferencies#getMinimumLevel()
 */
@Component
public class PokemonImpotanceFilter implements Filter {

    @Inject
    private Preferencies preferencies;

    @Override
    public boolean test(Appearance appearance) {
        return appearance.getPokemon().getImportance().compareTo(preferencies.getMinimumLevel()) >= 0;
    }

}