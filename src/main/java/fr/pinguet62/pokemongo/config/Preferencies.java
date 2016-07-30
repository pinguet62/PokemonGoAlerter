package fr.pinguet62.pokemongo.config;

import static fr.pinguet62.pokemongo.model.Importance.HIGH;
import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.model.Importance;
import fr.pinguet62.pokemongo.model.Position;
import fr.pinguet62.pokemongo.model.Zone;

@Component
public class Preferencies {

    public Importance getMinimumLevel() {
        return HIGH;
    }

    public List<Zone> getZones() {
        return asList(
                new Zone("Décathlon campus", new Position(50.648962, 3.138169), new Position(50.643492, 3.147423)),
                new Zone("Euratechnologies", new Position(50.634588, 3.018789), new Position(50.630802, 3.024139)),
                new Zone("Bois blanc", new Position(50.638707, 3.037083), new Position(50.625545, 3.018968)),
                new Zone("Citadelle", new Position(50.648113, 3.034545), new Position(50.635901, 3.053715)),
                new Zone("Parc Jean-Baptiste Lebas", new Position(50.628396, 3.067708),
                        new Position(50.624323, 3.070197)),
                new Zone("Australian Bar", new Position(50.642611, 3.062725), new Position(50.640664, 3.065490)),
                new Zone("Jardin des plantes", new Position(50.616288, 3.062421), new Position(50.613762, 3.072360)),
                new Zone("Parc Henri Matisse", new Position(50.642191, 3.074965), new Position(50.638017, 3.070101)),
                new Zone("Gares", new Position(50.634516, 3.069057), new Position(50.640156, 3.080119)),
                new Zone("Vieux Lille", new Position(50.651074, 3.049807), new Position(50.638982, 3.069538)),

                new Zone("Lille", new Position(50.651850, 3.014656), new Position(50.615879, 3.085065)));
    }

}