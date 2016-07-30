package fr.pinguet62.pokemongo.config;

import java.util.function.Function;

public class Configuration {

    public static Function<Double, Double> METER_TO_DEGREE = meter -> meter /* m */ * 0.0006866 /* ° */ / 100/* m */;

    public static final double SCAN_RADIUS = 1_000 /* m */;

    // Calculated: 100m = 0.0006866°
    public static final double COORDINATES_INTERVAL = METER_TO_DEGREE.apply(SCAN_RADIUS); // 0.0006866°;

}