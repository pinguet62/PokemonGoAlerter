package fr.pinguet62.pokemongo.preferencies;

import javax.inject.Inject;

import fr.pinguet62.pokemongo.Filter;
import fr.pinguet62.pokemongo.model.Appearance;

/**
 * {@link Filter#test(Appearance) Check} if {@link Appearance#getPosition() appearance position} is in any
 * {@link Preferencies#getZones()}.
 *
 * @see Preferencies#getZones()
 */
// @Component
public class InAnyZoneFilter implements Filter {

    @Inject
    private Preferencies preferencies;

    @Override
    public boolean test(Appearance appearance) {
        return preferencies.getZones().stream().anyMatch(zone -> zone.contains(appearance.getPosition()));
    }

}