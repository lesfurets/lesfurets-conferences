# LesFurets.com conférences

Conférences et présentations de l'équipe R&D du [comparateur d'assurance LesFurets.com](https://www.lesfurets.com).

* **[Continuous merge : réconcilier feature branching et continuous delivery](https://github.com/lesfurets/lesfurets-conferences#continuous-merge--r%C3%A9concilier-feature-branching-et-continuous-delivery)** ([open-source](https://github.com/lesfurets/git-octopus/)) : Notre organisation en feature branching & continuous merge
* **[DomainModel.stream()](https://github.com/lesfurets/lesfurets-conferences#domainmodelstream)** : Comment on applatit notre modèle de données dans un KVM (Key Value Mapping)
* **[Apache spark dans la vraie vie](https://github.com/lesfurets/lesfurets-conferences#apache-spark-dans-la-vraie-vie-de-d%C3%A9veloppeur-java)** : Apache spark dans la vraie vie (de développeur Java)
* **[Software craftmanship](https://github.com/lesfurets/lesfurets-conferences#software-craftmanship)** : Retour d’expérience sur notre manière de travailler ensemble sur le code
* **[Big Data](https://github.com/lesfurets/lesfurets-conferences#big-data)** : Retour d’expérience sur notre data
* **Zeno Pixel** ([open-source](https://github.com/lesfurets/zeno-pixel)) : Test de régression graphique pixel à pixel

## Conférences

### Continuous merge : réconcilier feature branching et continuous delivery

**Titre** : Continuous merge : réconcilier feature branching et continuous delivery

**Abstract** : Cette présentation offre des solutions tangibles au continuous delivery, qui couvrent le versionnement du code, la gestion des développements parallèles et le déploiement des artefacts. Ces solutions s'articulent autour du "continuous merge", rendu possible grâce à l'outil open-source "git-octopus" développé chez LesFurets.com. Le continuous merge est une pratique issue de nos 2 années de daily delivery et nous permet de détecter en amont les problèmes de merge entre les branches et de les résoudre rapidement. Cette pratique nous permet de livrer en production tous les jours sans sacrifier de qualité et sans alourdir le processus de développement.

**Title** : Continuous merge : Reconciling feature branching and continuous delivery

**Abstract** : This presentation tackles the subject of continuous delivery with tangible solutions, that covers code versioning, handling of multiple parallel developments and deployment of artifacts. The concept of "continuous merge", made possible by the open-source tool git-octopus developed at LesFurets.com, is the most important part of our continuous delivery process. Continuous merge is a process that emerged from 2 years of daily delivery and enables the early detection of merge problems between branches. It is therefore possible to push to production everyday without sacrificing quality and without adding a burden on our development process.

- 7 novembre 2016 (fr) : [WorkIT Software - Le continuous delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-workit-2016.html)
- 28 octobre 2016 (fr) : [Theodo - Le continuous delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-theodo-2016.html)
- 13 octobre 2016 (fr) : [Marseilles JUG - Le continuous delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-marseille-jug-2016.html)
- 29 juin 2016 (fr) : [Societe Generale - Le continuous delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/devops-chez-lesfurets-pour-sg.html)
- 28 juin 2016 (fr) : Paris JUG (https://www.parisjug.org/xwiki/wiki/oldversion/view/Meeting/20160628)
- 30 juin 2016 (fr) : Ch'ti JUG (http://chtijug.org/)
- 31 mai 2016 (fr) : Geneva JUG (http://genevajug.ch/jug/archive.html)
- 31 janvier 2016 (fr) : Tours JUG (http://www.toursjug.org)
- 10 décembre 2015 (fr) : [Octo - Le continuous merge chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/pdf/git-octopus-chez-octo-2015.pdf)
- 22 octobre 2015 (fr) : SoftShake Genève (http://soft-shake.ch/2015/fr/)
- 10 avril 2015 (fr) : [Devoxx France - Livrer chaque jour ce qui est prêt](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-agile-tour-rennes-2014.html)
- 5 mars 2015 (fr) : [BBL chez Viseo - Continuous Delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-BBL-viseo.html)
- 25 février 2015 (fr) : [Continuous Delivery Meetup - Continuous Delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-lean-kanban-france-2014.html)
- 1 novembre 2014 (fr) : [LeanKanban France 2014 - Continuous Delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-lean-kanban-france-2014.html)
- 1 octobre 2014 (en) : [Agile Cambrige 2014 - Continuous Delivery the french way](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-agile-cambridge-2014.html)
- 1 octobre 2014 (fr) : [AgileTour Rennes 2014 - Continuous Delivery chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-agile-tour-rennes-2014.html)

### DomainModel.stream()

**Abstract** : Pour faire du traitement de données, les listes, tableaux et maps sont les structures de données les plus faciles à manipuler. Malheureusement la plupart des applications sont conçues autour d'un modèle métier. Chez LesFurets.com nous avons résolu ce problème en développant un KVM (Key Value Mapping). Ce framework est utilisé au cœur de l'application et cohabite avec le modèle métier. Grâce au mapping bidirectionnel de notre modèle métier vers un modèle clé-valeur, les manipulations de données deviennent extrêmement simples à réaliser. La mise en place de ce nouveau paradigme a nécessité un important refactoring de l'application et a permis de l'ouvrir à de nombreux outils actuels (Stream Java 8, RxJava, Spark, Cassandra)

- 13 octobre 2016 (fr) : Marseille JUG (http://marsjug.org/#reunions)
- 28 juin 2016 (fr) : Paris JUG (https://www.parisjug.org/xwiki/wiki/oldversion/view/Meeting/20160628)
- 30 juin 2016 (fr) : Ch'ti JUG (http://chtijug.org/)
- 31 mai 2016 (fr) : Geneva JUG (http://genevajug.ch/jug/archive.html)
- 31 janvier 2016 (fr) : Tours JUG (http://www.toursjug.org)
- 8 janvier 2016 : Breizh JUG (http://www.breizhjug.org/#/events)
- 22 octobre 2015 (fr) : SoftShake Genève (http://soft-shake.ch/2015/fr/)

<!--
### Apache Spark dans la vraie vie (de développeur Java)
### Apache Spark : Utilisation journalière pour dévelopeur Java
### Apache Spark : Hands-on pour développeur Java
### A concise introduction to Apache Spark for Java developers
### Apache Spark : Real World Use Cases for Java Developers
### Apache Spark : Use cases réels pour développeurs Java
### Apache Spark : Utilisation pour développeurs Java et Mme Michu
### Apache Spark : Data science pour développeurs Java et Mme Michu
### Apache Spark : Hands-on pour développeurs Java et Mme Michu
### SparkOscope: Enabling Apache Spark Optimization Through Cross-Stack Monitoring and Visualization 
### Apache Spark : Hands-on pour développeurs Java dans la vraie vie
### Apache Spark : Hands-on pour développeurs Java avec de vrais use case
-->
### Apache Spark : Hands-on et use cases pour développeurs Java

**Abstract** : Spark est un framework open source de calcul distribué, utilisé pour faire de l'analyse de donnée sur de grands volumes. Mais devons-nous être "data scientist" et passionné de Scala pour l'utiliser ? Non seulement l'analyse de donnée avec Spark est à portée de tout développeur Java, mais elle permet d'avoir un impact direct sur le business. Depuis la version 2.0 de Spark, l'API des DataFrames permet de profiter des optimisations du moteur d'exécution peu importe le langage utilisé, dont Java. Nous allons utiliser Spark sur différentes sources de données (fichiers plats, MySQL, Cassandra) et dans des cas d'usages concrets basés sur les données de LesFurets.com (avec écriture de tests unitaires), en passant en revue les principales fonctionnalités du moteur, soit Spark Core, Spark SQL, Spark Streaming et Spark MLlib (Machine Learning Library), dans une présentation alternant slides et démonstrations live.

### JOOQ et JOOλ : le duo qui rend beau votre code de mapping de base de donnée

**Abstract** : JOOQ et JOOλ sont des solutions open-source permettant d'intégrer proprement votre application Java avec votre base de données. Quoi de nouveau sous le soleil me diriez-vous ? Après tout la problématique de mapping objet-relationnel est au moins aussi vieille que la plateforme Java. Mais depuis Java 8, JOOQ permet d'utiliser l'API Stream du JDK avec le mapping objet-relationnel, ce qui, couplé avec  JOOλ, a pour effet d'écrire des DAO plus simples et dans un paradigme fonctionnel. Au cours de ce tools in action nous allons vous présenter les avantages que nous pouvons tirer des frameworks JOOQ et JOOλ, par rapport à du JDBC pur sucre,  JPA sans oublier Spring JDBC Template. Cerise sur le gâteau, nous vous indiquerons comment simplement introduire JOOQ et JOOλ dans votre code existant.

<!-- 
### Applying Reactive programming for handling server-side concurrency
-->
### Programmation réactive pour gérer la concurrence côté serveur

**Abstract** : 
La concurrence côté serveur est un prérequis afin d'obtenir des temps de réponse acceptables pour les tâches d'orchestration de services externes.
Traditionnellement, Java traite la concurrence via des threads, des files d'attentes et des locks.
Bien que matures, ces constructions sont de très bas niveau pour travailler avec.
Non seulement ils sont sujets à l'erreur, ils manquent d'abstractions de haut niveau pour aider à mettre en œuvre des politiques pour l'optimisation des ressources, la résilience, la performance, etc.
La programmation réactive propose une solution pour gérer les problèmes de concurrence.
Basé sur des messages asynchrones, la programmation réactive permet aux développeurs de décrire les opérations sur les flux de données.
Dans cette présentation, nous démontrons nos efforts pour appliquer une programmation réactive sur une composante critique de notre architecture de backend chez LesFurets.com, l'orchestrateur de service.
En utilisant des exemples de code en direct, nous allons comparer différentes API telles que RxJava2, Reactive Streams (Java 9 Flow) et CompletableFutures.

<!--
Server-side concurrency is a must in order to achieve acceptable response times for tasks orchestrating external services.
Traditionally Java deals with concurrency via threads, queues and locks. 
Although mature, these constructs are very low-level to work with. 
Not only they are error-prone, they lack high-level abstractions to help implementing custom policies for resource optimization, resilience, performance, etc.
Reactive programming proposes a solution to handle concurrency problems. 
Based on asynchronous messages, reactive programming lets developers describe operations on top of streams of data.
In this presentation we demonstrate our efforts to apply reactive programming on a critical component of our backend architecture at LesFurets.com, the service orchestrator. 
Using live code examples we will compare different APIs such as RxJava2, Reactive Streams (Java 9 Flow) and CompletableFutures.
-->

### Software craftmanship

- 21 - 22 Avril 2016 (fr) : [Devoxx - France - Live code review at LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/live-code-review-at-lesfurets-devoxx.html)
- 4 mars 2016 (en) : [BGL Tech Conference - London - Live code review at LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/live-code-review-at-lesfurets.html)
- 26 novembre 2015 (fr) : [Codeurs en Seines - Rouen - Code review chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/code-review-chez-lesfurets.html)
- 25 juin 2015 (en) : [NWX Summer Festival - Rouen - Pair programming chez LesFurets.com](https://lesfurets.github.io/lesfurets-conferences/html/pair-programming-chez-lesfurets.html)

### Big Data

- 22 mars 2016 (fr) : Architecture Cassandra chez Ippon retour expérience (http://blog.ippon.fr/2016/03/16/retour-dexperience-lesfurets-com-le-22-mars/)
- 16 juin 2015 (en) : [Cassandra Days Paris 2015 - From 0 to Cassandra on AWS in 30 days - Tsunami alerting with Cassandra](https://lesfurets.github.io/lesfurets-conferences/pdf/cassandra-days-paris-from-0-to-cassandra-on-aws-in-30-days.pdf)

## Cours

- 7 octobre 2016 (fr) : [Université de Rouen - Gestion de version - git et svn (m1)](https://lesfurets.github.io/lesfurets-conferences/html/git-gestion-version-m1.html) / [Université de Rouen - Gestion de version - git et svn - TP](https://github.com/lesfurets/lesfurets-conferences/blob/gh-pages/tp/git-m1/TP.md)
- 1 décembre 2015 (fr) : [Université de Rouen - git (M1) Gestion de version](https://lesfurets.github.io/lesfurets-conferences/html/git-gestion-version-m1.html)
- TODO : cours cassandra

## Speakers

### Alexandre DuBreuil [@dubreuia](https://twitter.com/dubreuia)

Architecte canadien (certifié sans accent) de l'équipe data chez LesFurets.com, je m'intéresse particulièrement au software craftsmanship et à la manière de travailler efficacement le code en équipe. J'affectionne les sujets comme la gestion du code source, la construction d'application et les techniques de continuous delivery.

### Ozan Gunalp [@ozangunalp](https://twitter.com/ozangunalp)

Ingénieur docteur avec 5+ ans d'expérience dans les systèmes distribués, l'Internet des objets et les processus de développement logiciels.
Chez LesFurets.com je m'intéresse à l'amélioration de la qualité et du pipeline de livraison de logiciel.

## Vidéos

- BreizhCamp - Rennes - Continuous delivery : https://www.youtube.com/watch?v=ayvVYc01iEk
- The French Way (en) - Agile Cambridge - Continuous delivery : https://www.youtube.com/watch?v=ayvVYc01iEk
- SoftIt - Continuous delivery : http://blog.softit.fr/?tag=/Continuous+Delivery+to+Lean+Enterprise
- GenevaJUG Session - Domain().stream() et Continuous merge : https://www.youtube.com/watch?v=mRu30jO2c18

## Idée de conférences

* Monitoring ops & métier avec datadog / graphite-tessera
* Eviter les conflits de code (inventaire, résolution, stratégie)
* Mon A3 lean sur la trop grande quantité de code par release, root cause analysis et amélioration
* Architecture wordpress multi-site (si interessés)
* REX FLYWAY DB, upgrade automatique de la base de données
* Infra Selenium Grid : 200 séléniums sur une machine en 10min c'est possible (grid docker en ram)
* Infra docker de tests (et déploiement local dev avec dns)

## Installation reveal

Il faut avoir bower pour mettre à jour reveal.js, tout est commité dans `bower_components/reveal.js` et linké dans les présentations.

    sudo install -g bower

Pour savoir s'il y a une nouvelle version de reveal.js

    bower info reveal.js

Ensuite il faut mettre à jour le bower.json

## Infos / Questions

- Twitter : https://twitter.com/BeastieFurets

