package fr.pinguet62.pokemongo.test;

import static fr.pinguet62.pokemongo.config.Configuration.SCAN_RADIUS;
import static fr.pinguet62.pokemongo.model.Position.distance;

import org.junit.Test;

import fr.pinguet62.pokemongo.model.Position;

/** Recherche de la valeur du delta sur les coordonnées pour obtenir un delta sur la distance (verticale ou horizontale). */
public class PositionDelta {

	@Test
	public void calculate() {
		Position origine = new Position(0, 0);
		Position recherche = new Position(0, 90);
		while (distance(origine, recherche) > SCAN_RADIUS)
			recherche = new Position((origine.getLatitude() + recherche.getLatitude()) / 2, (origine.getLongitude() + recherche.getLongitude()) / 2);
		System.out.println(recherche);
	}

}