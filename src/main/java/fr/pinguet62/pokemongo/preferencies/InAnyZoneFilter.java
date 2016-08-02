package fr.pinguet62.pokemongo.preferencies;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.Filter;
import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.model.Zone;

/**
 * {@link Filter#test(Appearance) Check} if {@link Appearance#getPosition() appearance position} is in any
 * {@link Preferencies#getZones()}.
 *
 * @see Preferencies#getZones()
 */
@Component
public class InAnyZoneFilter implements Filter {

    @Inject
    private Preferencies preferencies;

    @Override
    public boolean test(Appearance appearance) {
        Optional<Zone> opZone = preferencies.getZones().stream().filter(zone -> zone.contains(appearance.getPosition()))
                .findFirst();
        if (!opZone.isPresent())
            return false;
        appearance.setZone(opZone.get());
        return true;
    }

}