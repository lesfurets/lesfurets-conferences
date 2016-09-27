# LesFurets.com conférences

Conférences et présentations de l'équipe R&D du [comparateur d'assurance LesFurets.com](https://www.lesfurets.com).

* **Git Octopus** ([open-source](https://github.com/lesfurets/git-octopus/)) : Notre organisation en feature branching & continuous merge
* **Continuous delivery** : Historique et mindset sur le chemin du continuous delivery
* **Architecture Cassandra** : Retour d’expérience sur l’évolution de notre infrastructure vers une architecture lambda
* **DomainModel.stream()** : Comment on applatit notre modèle de données dans un KVM (Key Value Mapping)
* **Zeno Pixel** ([open-source](https://github.com/lesfurets/zeno-pixel)) : Test de régression graphique pixel à pixel

## Continuous delivery / git octopus

Nous allons faire un tour d'horizon de notre process de mise en production chez LesFurets.com pour comprendre comment nous arrivons à faire du continuous delivery, avec des mises en production tous les jours. Nous allons surtout parler de notre outil "git octopus", qui nous permet de faire du continuous merge, et de détecter en amont les problèmes de merge entre nos branches.

- 13 octobre 2016 (fr) : [Marseilles JUG - Le continuous delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-marseille-jug-2016.html)
- 29 juin 2016 (fr) : [Societe Generale - Le continuous delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/devops-chez-lesfurets-pour-sg.html)
- 10 décembre 2015 (fr) : [Octo - Le continuous merge chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/pdf/git-octopus-chez-octo-2015.pdf)
- 10 avril 2015 (fr) : [Devoxx France - Livrer chaque jour ce qui est prêt](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-agile-tour-rennes-2014.html)
- 5 mars 2015 (fr) : [BBL chez Viseo - Continuous Delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-BBL-viseo.html)
- 25 février 2015 (fr) : [Continuous Delivery Meetup - Continuous Delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-lean-kanban-france-2014.html)
- 1 novembre 2014 (fr) : [LeanKanban France 2014 - Continuous Delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-lean-kanban-france-2014.html)
- 1 octobre 2014 (en) : [Agile Cambrige 2014 - Continuous Delivery the french way](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-agile-cambridge-2014.html)
- 1 octobre 2014 (fr) : [AgileTour Rennes 2014 - Continuous Delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-agile-tour-rennes-2014.html)

## DomainModel.stream()

Pour faire du traitement de données, les listes, tableaux et maps sont les structures de données les plus faciles à manipuler. Malheureusement la plupart des applications sont conçues autour d'un modèle métier.

Chez LesFurets.com nous avons résolu ce problème en développant un KVM (Key Value Mapping). Ce framework est utilisé au cœur de l'application et cohabite avec le modèle métier. Grâce au mapping bidirectionnel de notre modèle métier vers un modèle clé-valeur, les manipulations de données deviennent extrêmement simples à réaliser. La mise en place de ce nouveau paradigme a nécessité un important refactoring de l'application et a permis de l'ouvrir à de nombreux outils actuels (Stream Java 8, RxJava, Spark, Cassandra)

- TODO : SoftShake
- TODO : JUG Tours
- TODO ...

## Software craftmanship

- 21 - 22 Avril 2016 (fr) : [Devoxx - France - Live code review at LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/live-code-review-at-lesfurets-devoxx.html)
- 4 mars 2016 (en) : [BGL Tech Conference - London - Live code review at LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/live-code-review-at-lesfurets.html)
- 26 novembre 2015 (fr) : [Codeurs en Seines - Rouen - Code review chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/code-review-chez-lesfurets.html)
- 25 juin 2015 (en) : [NWX Summer Festival - Rouen - Pair programming chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/pair-programming-chez-lesfurets.html)

## Big Data

- 16 juin 2015 (anglais) : [Cassandra Days Paris 2015 - From 0 to Cassandra on AWS in 30 days - Tsunami alerting with Cassandra](https://lesfurets.github.io/lesfurets-conferences/pdf/cassandra-days-paris-from-0-to-cassandra-on-aws-in-30-days.pdf)

## Cours

- 1 décembre 2015 (fr) : [Université de Rouen - git (M1) Gestion de version](https://lesfurets.github.io/lesfurets-conferences/html/git-gestion-version-m1.html)
- TODO : cours cassandra

# Vidéos

- BreizhCamp - Rennes - Continuous delivery : https://www.youtube.com/watch?v=ayvVYc01iEk
- The French Way (en) - Agile Cambridge - Continuous delivery : https://www.youtube.com/watch?v=ayvVYc01iEk
- SoftIt - Continuous delivery : http://blog.softit.fr/?tag=/Continuous+Delivery+to+Lean+Enterprise

# Idée de conférences

* Monitoring ops & métier avec datadog / graphite-tessera
* Eviter les conflits de code (inventaire, résolution, stratégie)
* Mon A3 lean sur la trop grande quantité de code par release, root cause analysis et amélioration
* Architecture wordpress multi-site (si interessés)
* REX FLYWAY DB, upgrade automatique de la base de données
* Infra Selenium Grid : 200 séléniums sur une machine en 10min c'est possible (grid docker en ram)
* Infra docker de tests (et déploiement local dev avec dns)

# Installation reveal

Il faut avoir bower pour mettre à jour reveal.js, tout est commité dans `bower_components/reveal.js` et linké dans les présentations.

    sudo install -g bower

Pour savoir s'il y a une nouvelle version de reveal.js

    bower info reveal.js

Ensuite il faut mettre à jour le bower.json

# Infos / Questions

- Twitter : https://twitter.com/BeastieFurets

