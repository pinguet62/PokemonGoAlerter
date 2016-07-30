package fr.pinguet62.pokemongo.model;

import static fr.pinguet62.pokemongo.model.Position.distance;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** @see Position */
public class PositionTest {

	/**
	 * @see <a href="https://www.google.fr/maps/dir/50.6364906,3.0447125/50.6222891,3.0718954/@50.6322292,3.047721,15.75z/data=!4m2!4m1!3e2">Google Map</a>
	 * @see Position#distance(Position, Position)
	 */
	@Test
	public void test_distance() {
		assertEquals(2_500, distance(new Position(50.636503, 3.044745), new Position(50.622289, 3.071883)), 100/* à mètre près */);
	}

}