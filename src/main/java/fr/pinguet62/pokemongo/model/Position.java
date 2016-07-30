package fr.pinguet62.pokemongo.model;

import static java.lang.Math.PI;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;

public class Position {

    public static final DecimalFormat formatter;

    static {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        formatter = new DecimalFormat("#0.0000000", decimalFormatSymbols);
    }

    /**
     * Calculate the distance between 2 {@link Position}s.
     * <p>
     * <code>Ortho(A,B)=6371 x acos[ sin(LatA) x sin(LatB) + cos(LatA) x cos(LatB) x cos(LongB-LongA)]</code>
     *
     * @return The distance, in <b>meter</b>.
     * @see <a href=
     *      "http://www.01net.com/astuces/astuce-excel-calculez-la-distance-entre-deux-points-de-la-terre-555908.html">
     *      01net</a>
     */
    public static double distance(Position p1, Position p2) {
        // return sqrt(Math.pow(p1.getLatitude() - p2.getLatitude(), 2) + Math.pow(p1.getLongitude() -
        // p2.getLongitude(), 2));
        // @formatter:off
		return 6371.0 * acos(
					sin(toRadian(p1.getLatitude())) * sin(toRadian(p2.getLatitude()))
				+   cos(toRadian(p1.getLatitude())) * cos(toRadian(p2.getLatitude())) * cos(toRadian(p2.getLongitude()) - toRadian(p1.getLongitude()))
			) * 1_000 /*km to m*/;
		// @formatter:on
    }

    /**
     * Convert degree to radian.
     *
     * @param degree The GPS degree value.
     * @return The radian.
     */
    private static double toRadian(double degree) {
        return (degree / 180) * PI;
    }

    private final double latitude;

    private final double longitude;

    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Position))
            return false;
        Position other = (Position) obj;
        return Objects.equals(latitude, other.latitude) && Objects.equals(longitude, other.longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public URL getUrl() {
        try {
            return new URL(
                    "http://maps.google.com/maps?q=" + formatter.format(latitude) + "," + formatter.format(longitude));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "(" + formatter.format(latitude) + ", " + formatter.format(longitude) + ")";
    }

}