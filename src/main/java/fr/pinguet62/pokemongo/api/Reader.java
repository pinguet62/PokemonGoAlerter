package fr.pinguet62.pokemongo.api;

import java.util.List;

import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.model.Position;
import fr.pinguet62.pokemongo.model.Zone;

/** Reader used to extract {@link Appearance}s from data-source. */
public interface Reader {

    List<Appearance> get(Position position);

    /** Interval used by criss-cross algorithme for scan all {@link Zone}s. */
    double getInterval();

}