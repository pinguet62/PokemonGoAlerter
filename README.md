# Pokemon GO alerter

[![Build Status](https://travis-ci.org/pinguet62/PokemonGoAlerter.svg?branch=master)](https://travis-ci.org/pinguet62/PokemonGoAlerter)

## Zones à scanner

La liste des zones (couple de coordonnées) est définie dans la classe `fr.pinguet62.pokemongo.config.Preferencies`.  
La zone totale à couvrir est représentée par l'ensemble des `Zone` constitué d'un couple de `Position`. Ils sont nommés afin d'avoir un détail dans la notification.

Parce que toute la zone ne peut pas être scannée en entier, la zone totale est scannée par morceaux. Voir méthode `Zone::crissCross()`.

## Message

Les messages envoyés sont de cette forme :

```
Minidraco
End: 08:21:36
Zone: Citadelle
http://maps.google.com/maps?q=50.6379695,3.0502286
```

## Notification

### Implémentation par défaut

Le programme envoie un message sur un compte Facebook.  
Il faut donc configurer un aure compte que celui cible.

La configuration des identifiants se fait dans le fichier `application.yml`.

### Notification personnalisée

Il est possible de créer ses propres systèmes de notification.

Il faut pour cela créer les **@Bean** implémentant l'interface : `fr.pinguet62.pokemongo.notification.Sender`.

## Niveau d'alert

La classe `fr.pinguet62.pokemongo.model.Pokemon` contient en 3ème argument le niveau d'alerte (3 valeurs).  
TODO : séparer la configuration du model.

Le niveau minimum de filtrage des alertes est définie dans `fr.pinguet62.pokemongo.config.Preferencies`.
