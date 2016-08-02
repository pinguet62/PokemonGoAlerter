package fr.pinguet62.pokemongo;

import static fr.pinguet62.pokemongo.model.Position.distance;

import java.util.function.Function;

import fr.pinguet62.pokemongo.model.Position;

public class Configuration {

    /** Convert <code>meter</code> to <code>degrees</code>. */
    public static Function<Double, Double> METER_TO_DEGREE = meter -> meter
            /* m */ / distance(new Position(0, 0), new Position(0, 1)) /* °/m */;

}