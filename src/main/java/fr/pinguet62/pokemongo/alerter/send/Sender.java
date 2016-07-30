package fr.pinguet62.pokemongo.alerter.send;

import fr.pinguet62.pokemongo.alerter.Message;

public interface Sender {

    public void send(Message message);

}