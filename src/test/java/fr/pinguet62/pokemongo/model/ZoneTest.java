package fr.pinguet62.pokemongo.model;

import static java.lang.Math.sqrt;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** @see Zone */
public class ZoneTest {

    private static final double R = 1;

    private static final double DELTA = 2 * (sqrt(2) / 2) * R;

    @Test
    public void test_crissCross_count() {
        List<Zone> zones = asList(new Zone("", new Position(0, 0), new Position(2 * DELTA, 2 * DELTA)));
        List<Position> positions = new ArrayList<>();
        Zone.crissCross(zones, DELTA, p -> positions.add(p));
        assertEquals(4, positions.size());
    }

    @Test
    public void test_crissCross_nextDistant() {
        List<Zone> zones = asList(new Zone("", new Position(0, 1.5 * DELTA), new Position(99, 99)),
                new Zone("", new Position(55, 0), new Position(99, 99)));
        List<Position> positions = new ArrayList<>();
        Zone.crissCross(zones, DELTA, p -> positions.add(p));
        assertFalse(positions.contains(new Position(0.5 * DELTA, 0.5 * DELTA)));
        assertTrue(positions.contains(new Position(0.5 * DELTA, 1.5 * DELTA)));
    }

    @Test
    public void test_crissCross_nextNear() {
        List<Zone> zones = asList(new Zone("", new Position(0, 0.5 * DELTA), new Position(99, 99)),
                new Zone("", new Position(55, 0), new Position(99, 99)));
        List<Position> positions = new ArrayList<>();
        Zone.crissCross(zones, DELTA, p -> positions.add(p));
        assertTrue(positions.contains(new Position(0.5 * DELTA, 0.5 * DELTA)));
    }

    @Test
    public void test_crissCross_previousDistant() {
        List<Zone> zones = asList(new Zone("", new Position(0, 0), new Position(55, 0.9 * DELTA)),
                new Zone("", new Position(55, 55), new Position(99, 99)));
        List<Position> positions = new ArrayList<>();
        Zone.crissCross(zones, DELTA, p -> positions.add(p));
        assertTrue(positions.contains(new Position(0.5 * DELTA, 0.5 * DELTA)));
        assertFalse(positions.contains(new Position(0.5 * DELTA, 1.5 * DELTA)));
    }

    @Test
    public void test_crissCross_previousNear() {
        List<Zone> zones = asList(new Zone("", new Position(0, 0), new Position(55, 1.1 * DELTA)),
                new Zone("", new Position(55, 55), new Position(99, 99)));
        List<Position> positions = new ArrayList<>();
        Zone.crissCross(zones, DELTA, p -> positions.add(p));
        assertTrue(positions.contains(new Position(0.5 * DELTA, 0.5 * DELTA)));
        assertTrue(positions.contains(new Position(0.5 * DELTA, 1.5 * DELTA)));
    }

}