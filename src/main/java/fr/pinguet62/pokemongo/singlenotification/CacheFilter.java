package fr.pinguet62.pokemongo.singlenotification;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.Filter;
import fr.pinguet62.pokemongo.model.Appearance;

/** {@link Filter#test(Appearance) Check} if {@link Appearance} already be processed. */
@Component
public class CacheFilter implements Filter {

    @Inject
    private Cache cache;

    /** @see Cache#contains(Appearance) */
    @Override
    public boolean test(Appearance appearance) {
        return !cache.contains(appearance);
    }

}