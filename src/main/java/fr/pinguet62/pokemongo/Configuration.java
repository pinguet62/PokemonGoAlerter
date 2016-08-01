package fr.pinguet62.pokemongo;

import static fr.pinguet62.pokemongo.model.Position.distance;
import static java.lang.Math.sqrt;

import java.util.function.Function;

import fr.pinguet62.pokemongo.api.Reader;
import fr.pinguet62.pokemongo.api.pokevision.PokevisionApi;
import fr.pinguet62.pokemongo.model.Position;

public class Configuration {

    /** Convert <code>meter</code> to <code>degrees</code>. */
    static Function<Double, Double> METER_TO_DEGREE = meter -> meter
            /* m */ / distance(new Position(0, 0), new Position(0, 1)) /* °/m */;

    /**
     * Depend on {@link Reader}. <br>
     * Calculated by average.
     * 
     * @see PokevisionApi
     */
    public static final double SCAN_RADIUS_METER = 1_000 /* m */;

    /**
     * {@link #SCAN_RADIUS_METER} converted to degrees.<br>
     * Distance for only vertical or horizontal delta.
     */
    public static final double SCAN_RADIUS_DEGREE = METER_TO_DEGREE.apply(SCAN_RADIUS_METER); // 0.0006866°;

    public static final double CRISSCROSS_INTERVAL = sqrt(2) * SCAN_RADIUS_DEGREE;

}