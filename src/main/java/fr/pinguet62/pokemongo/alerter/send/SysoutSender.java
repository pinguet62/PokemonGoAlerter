package fr.pinguet62.pokemongo.alerter.send;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.alerter.Message;

@Component
public class SysoutSender implements Sender {

    @Override
    public void send(Message message) {
        System.out.println(message);
        System.out.println("------------------------");
    }

}