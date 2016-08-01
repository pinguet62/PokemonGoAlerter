package fr.pinguet62.pokemongo;

import java.util.function.Predicate;

import fr.pinguet62.pokemongo.model.Appearance;

public interface Filter extends Predicate<Appearance> {

    default Filter and(Filter other) {
        return (t) -> test(t) && other.test(t);
    }

}