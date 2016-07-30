package fr.pinguet62.pokemongo.alerter;

import static java.lang.System.lineSeparator;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.pinguet62.pokemongo.model.Pokemon;
import fr.pinguet62.pokemongo.model.Position;
import fr.pinguet62.pokemongo.model.Zone;

public class Message {

    private final Date expirationTime;

    private final Pokemon pokemon;

    private final Position position;

    private final Zone zone;

    public Message(Pokemon pokemon, Zone zone, Date expirationTime, Position position) {
        this.pokemon = pokemon;
        this.zone = zone;
        this.expirationTime = expirationTime;
        this.position = position;
    }

    @Override
    public String toString() {
        String message = pokemon.getName();
        message += lineSeparator() + "End: " + new SimpleDateFormat("hh:mm:ss").format(expirationTime);
        if (zone != null)
            message += lineSeparator() + "Zone: " + zone.getName();
        message += lineSeparator() + position.getUrl();
        return message;
    }

}