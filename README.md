# Pokemon GO alerter

## Zones à scanner

La liste des zones (couple de coordonnées) est définie dans la classe `fr.pinguet62.pokemongo.config.Preferencies`.

## Notification

### Implémentation par défaut

Le programme envoie un message sur un compte Facebook.  
Il faut donc configurer un aure compte que celui cible.

La configuration des identifiants se fait dans le fichier `application.yml`.

### Déboguage

Le bean `fr.pinguet62.pokemongo.alerter.send.SysoutSender` permet d'afficher les messages dans la console durant les tests.

### Notification personnalisée

Implémenter son **@Bean** implémentant : `fr.pinguet62.pokemongo.alerter.send.Sender`

## Niveau d'alert

La classe `fr.pinguet62.pokemongo.model.Pokemon` contient en 3ème argument le niveau d'alerte (3 valeurs).  
TODO : séparer la configuration du model.

Le niveau minimum de filtrage des alertes est définie dans `fr.pinguet62.pokemongo.config.Preferencies`.
