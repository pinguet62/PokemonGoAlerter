package fr.pinguet62.pokemongo.notification.impl;

import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.notification.Sender;

/** @see System#out */
@Component
public class SysoutSender implements Sender {

    @Override
    public void accept(Appearance appearance) {
        System.out.println(appearance);
        System.out.println("--------------------------------------------------");
    }

}