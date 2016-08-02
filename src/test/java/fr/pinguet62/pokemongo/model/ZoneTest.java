package fr.pinguet62.pokemongo.model;

import static java.lang.Math.sqrt;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/** @see Zone */
public class ZoneTest {

    private static final double R = 1;

    private static final double DELTA = 2 * (sqrt(2) / 2) * R;

    /** @see Zone#crissCross(List, double) */
    @Test
    public void test_crissCross_count() {
        List<Zone> zones = asList(new Zone(new Position(0, 0), new Position(2 * DELTA, 2 * DELTA)));
        List<Position> positions = Zone.crissCross(zones, DELTA).collect(toList());
        assertEquals(4, positions.size());
    }

    /**
     * The {@link Position} is out (before) of zone, but is distant: the next {@link Position} will scan the entire
     * surface: this {@link Position} must not be processed.
     * 
     * @see Zone#crissCross(List, double)
     */
    @Test
    public void test_crissCross_nextDistant() {
        List<Zone> zones = asList(new Zone(new Position(0, 1.5 * DELTA), new Position(99, 99)),
                new Zone(new Position(55, 0), new Position(99, 99)));
        List<Position> positions = Zone.crissCross(zones, DELTA).collect(toList());
        assertFalse(positions.contains(new Position(0.5 * DELTA, 0.5 * DELTA)));
        assertTrue(positions.contains(new Position(0.5 * DELTA, 1.5 * DELTA)));
    }

    /**
     * The {@link Position} is out (before) of zone, but is near: the next {@link Position} will not scan the entire
     * surface: this {@link Position} must be processed.
     * 
     * @see Zone#crissCross(List, double)
     */
    @Test
    public void test_crissCross_nextNear() {
        List<Zone> zones = asList(new Zone(new Position(0, 0.5 * DELTA), new Position(99, 99)),
                new Zone(new Position(55, 0), new Position(99, 99)));
        List<Position> positions = Zone.crissCross(zones, DELTA).collect(toList());
        assertTrue(positions.contains(new Position(0.5 * DELTA, 0.5 * DELTA)));
    }

    /**
     * The {@link Position} is out (after) of zone, but is distant: the previous {@link Position} scanned the entire
     * surface: this {@link Position} must not be processed.
     * 
     * @see Zone#crissCross(List, double)
     */
    @Test
    public void test_crissCross_previousDistant() {
        List<Zone> zones = asList(new Zone(new Position(0, 0), new Position(55, 0.9 * DELTA)),
                new Zone(new Position(55, 55), new Position(99, 99)));
        List<Position> positions = Zone.crissCross(zones, DELTA).collect(toList());
        assertTrue(positions.contains(new Position(0.5 * DELTA, 0.5 * DELTA)));
        assertFalse(positions.contains(new Position(0.5 * DELTA, 1.5 * DELTA)));
    }

    /**
     * The {@link Position} is out (after) of zone, but is near: the previous {@link Position} could not scan the entire
     * surface: this {@link Position} must be processed.
     * 
     * @see Zone#crissCross(List, double)
     */
    @Test
    public void test_crissCross_previousNear() {
        List<Zone> zones = asList(new Zone(new Position(0, 0), new Position(55, 1.1 * DELTA)),
                new Zone(new Position(55, 55), new Position(99, 99)));
        List<Position> positions = Zone.crissCross(zones, DELTA).collect(toList());
        assertTrue(positions.contains(new Position(0.5 * DELTA, 0.5 * DELTA)));
        assertTrue(positions.contains(new Position(0.5 * DELTA, 1.5 * DELTA)));
    }

}