package fr.pinguet62.pokemongo.model;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.List;
import java.util.function.Consumer;

import com.google.common.base.Objects;

public class Zone {

    private static boolean between(double min, double value, double max) {
        return min <= value && value <= max;
    }

    /**
     * Divide zone and execute {@link Consumer} on each position.
     *
     * @param zones The {@link Zone}s.
     * @param interval The length of one side of the square.
     * @param action The {@link Consumer} to execute on current {@link Position}.
     */
    public static final void crissCross(List<Zone> zones, double interval, Consumer<Position> action) {
        double minLatitude = zones.stream().map(z -> z.bottomLeft).map(Position::getLatitude)
                .mapToDouble(Double::doubleValue).min().getAsDouble();
        double maxLatitude = zones.stream().map(z -> z.topRight).map(Position::getLatitude)
                .mapToDouble(Double::doubleValue).max().getAsDouble();
        double minLongitude = zones.stream().map(z -> z.bottomLeft).map(Position::getLongitude)
                .mapToDouble(Double::doubleValue).min().getAsDouble();
        double maxLongitude = zones.stream().map(z -> z.topRight).map(Position::getLongitude)
                .mapToDouble(Double::doubleValue).max().getAsDouble();
        for (double latitude = minLatitude + (interval / 2); latitude
                - (interval / 2) < maxLatitude; latitude += interval)
            for (double longitude = minLongitude + (interval / 2); longitude
                    - (interval / 2) < maxLongitude; longitude += interval) {
                Position position = new Position(latitude, longitude);

                // Check if scan from this position lap any zone
                if (!zones.stream()
                        .anyMatch(z -> between(z.bottomLeft.getLatitude() - interval / 2, position.getLatitude(),
                                z.topRight.getLatitude() + interval / 2)
                                && between(z.bottomLeft.getLongitude() - interval / 2, position.getLongitude(),
                                        z.topRight.getLongitude() + interval / 2)))
                    continue;

                action.accept(position);
            }
    }

    // min latitude & longitude
    final Position bottomLeft;

    // max latitude & longitude
    private final String name;

    final Position topRight;

    public Zone(String name, Position x, Position y) {
        this.name = name;
        bottomLeft = new Position(min(x.getLatitude(), y.getLatitude()), min(x.getLongitude(), y.getLongitude()));
        topRight = new Position(max(x.getLatitude(), y.getLatitude()), max(x.getLongitude(), y.getLongitude()));
    }

    public boolean contains(Position position) {
        return bottomLeft.getLatitude() <= position.getLatitude() && position.getLatitude() <= topRight.getLatitude()
                && bottomLeft.getLongitude() <= position.getLongitude()
                && position.getLongitude() <= topRight.getLongitude();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Zone))
            return false;
        Zone other = (Zone) obj;
        return Objects.equal(bottomLeft, other.bottomLeft) && Objects.equal(topRight, other.topRight);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bottomLeft, topRight);
    }

    @Override
    public String toString() {
        return name;
    }

}