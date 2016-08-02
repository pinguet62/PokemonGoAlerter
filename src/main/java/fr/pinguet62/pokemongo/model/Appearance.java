package fr.pinguet62.pokemongo.model;

import static java.lang.System.lineSeparator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import fr.pinguet62.pokemongo.preferencies.Preferencies;

public class Appearance {

    private final Date expiration;

    private final Pokemon pokemon;

    private final Position position;

    /** First {@link Zone} of {@link Preferencies} where {@link Position} was content. */
    private Zone zone;

    public Appearance(Pokemon pokemon, Position position, Date expiration) {
        this.pokemon = pokemon;
        this.position = position;
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(getClass().equals(obj.getClass())))
            return false;
        Appearance other = (Appearance) obj;
        return Objects.equals(pokemon, other.pokemon) && Objects.equals(position, other.position)
                && Objects.equals(expiration, other.expiration);
    }

    public Date getExpiration() {
        return expiration;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Position getPosition() {
        return position;
    }

    public Zone getZone() {
        return zone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemon, position, expiration);
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    // TODO Formatter
    @Override
    public String toString() {
        String message = pokemon.getName() + lineSeparator();
        message += "End: " + new SimpleDateFormat("HH:mm:ss").format(expiration) + lineSeparator();
        message += "Zone: " + zone.getName() + lineSeparator();
        message += position.getUrl();
        return message;
    }

}