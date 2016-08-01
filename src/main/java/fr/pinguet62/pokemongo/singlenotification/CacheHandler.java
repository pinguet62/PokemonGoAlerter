package fr.pinguet62.pokemongo.singlenotification;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.Handler;
import fr.pinguet62.pokemongo.model.Appearance;

/** Save {@link Appearance} to {@link Cache}. */
@Component
public class CacheHandler implements Handler {

    @Inject
    private Cache cache;

    /** @see Cache#add(Appearance) */
    @Override
    public void accept(Appearance appearance) {
        cache.add(appearance);
    }

}