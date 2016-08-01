package fr.pinguet62.pokemongo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/** @see Configuration */
public class ConfigurationTest {

    /**
     * Calculate the {@link Configuration#METER_TO_DEGREE} coefficient.
     *
     * @see Configuration#METER_TO_DEGREE
     */
    @Test
    public void test_METER_TO_DEGREE() {
        assertTrue(Configuration.METER_TO_DEGREE.apply(1.0) < 0.001);
    }

}