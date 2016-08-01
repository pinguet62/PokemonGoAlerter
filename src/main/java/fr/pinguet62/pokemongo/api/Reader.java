package fr.pinguet62.pokemongo.api;

import java.util.List;

import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.model.Position;

/** Reader used to extract {@link Appearance}s from data-source. */
public interface Reader {

    List<Appearance> get(Position position);

}