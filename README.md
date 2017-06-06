# LesFurets.com conférences

Conférences et présentations de l'équipe R&D du [comparateur d'assurance LesFurets.com](https://www.lesfurets.com).

* **[Continuous merge : réconcilier feature branching et continuous delivery](https://github.com/lesfurets/lesfurets-conferences#continuous-merge--r%C3%A9concilier-feature-branching-et-continuous-delivery)** ([open-source](https://github.com/lesfurets/git-octopus/)) : Notre organisation en feature branching & continuous merge
* **[DomainModel.stream()](https://github.com/lesfurets/lesfurets-conferences#domainmodelstream)** : Comment on applatit notre modèle de données dans un KVM (Key Value Mapping)
* **[Apache Spark : Deep dive dans l'API Java pour développeur](https://github.com/lesfurets/lesfurets-conferences#apache-spark--deep-dive-dans-lapi-java-pour-développeur)** : Application de spark sur des cas d'usage pour développeurs Java
* **[Software craftmanship](https://github.com/lesfurets/lesfurets-conferences#software-craftmanship)** : Retour d’expérience sur notre manière de travailler ensemble sur le code
* **[Big Data](https://github.com/lesfurets/lesfurets-conferences#big-data)** : Retour d’expérience sur notre data
* **Zeno Pixel** ([open-source](https://github.com/lesfurets/zeno-pixel)) : Test de régression graphique pixel à pixel
* **[JenkinsPipelineUnit](https://github.com/lesfurets/lesfurets-conferences#jenkinspipelineunit-test-your-continuous-delivery-pipeline)** : Test your continuous delivery pipeline

## Conférences

### Continuous merge : réconcilier feature branching et continuous delivery

**Titre** : Continuous merge : réconcilier feature branching et continuous delivery

**Abstract** : Cette présentation offre des solutions tangibles au continuous delivery, qui couvrent le versionnement du code, la gestion des développements parallèles et le déploiement des artefacts. Ces solutions s'articulent autour du "continuous merge", rendu possible grâce à l'outil open-source "git-octopus" développé chez LesFurets.com. Le continuous merge est une pratique issue de nos 2 années de daily delivery et nous permet de détecter en amont les problèmes de merge entre les branches et de les résoudre rapidement. Cette pratique nous permet de livrer en production tous les jours sans sacrifier de qualité et sans alourdir le processus de développement.

**Title** : Continuous merge : Reconciling feature branching and continuous delivery

**Abstract** : This presentation tackles the subject of continuous delivery with tangible solutions, that covers code versioning, handling of multiple parallel developments and deployment of artifacts. The concept of "continuous merge", made possible by the open-source tool git-octopus developed at LesFurets.com, is the most important part of our continuous delivery process. Continuous merge is a process that emerged from 2 years of daily delivery and enables the early detection of merge problems between branches. It is therefore possible to push to production everyday without sacrificing quality and without adding a burden on our development process.

- 14 juin 2017 (fr) : [Open R&D day - Le continuous merge](https://lesfurets.github.io/lesfurets-conferences/html/continuous-delivery-open-r-and-d-day.html)
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
### Apache Spark : Deep dive dans l'API Java pour développeur

Code source pour live code : [https://github.com/lesfurets/lesfurets-conferences/tree/gh-pages/src/apache-spark](https://github.com/lesfurets/lesfurets-conferences/tree/gh-pages/src/apache-spark)

**Abstract** : Apache Spark propose une API Java comme langage principal, mais est-elle aussi puissante que l'API Scala ? Utilise-t-elle toutes les fonctionnalités du langage, comme les lambdas ? Comment intégrer Spark à nos outils de tests unitaires et à notre code base existante ? Nous allons donc plonger dans l'API Java de Spark avec des exemples et du live coding, en couvrant l'usage du cœur de Spark, la gestion des dépendances, les tests unitaires avec JUnit, le lancement à partir d'un IDE et l'intégration du code Spark avec notre code base Java existante. Depuis Spark 2.0, l'API DataFrame unifiée entre les langages rend Spark plus facile à utiliser et plus rapide à exécuter en Java, mais il existe pour l'instant peu de documentation sur des cas d'usages spécifiques, et plusieurs particularités de syntaxe rendent le code Scala difficile à convertir en Java. Les slides et le live coding vont présenter les bons et les mauvais moments que notre équipe de développement Java a rencontrés en utilisant Spark.

**Apache Spark : Deep dive into the Java API for developers** : Apache Spark proposes a Java API as a first class citizen, but is it as powerful as the Scala API? Does it use every feature of the language, such as lambdas? Does it integrate properly with our unit test tooling and existing Java code base? We will dive into the Spark Java API through examples and live coding from our code base, by covering the basic usage and dependency management, unit testing with JUnit, launching from an IDE and integrating Spark code with our existing Java code base. Since Spark version 2.0, the unified DataFrame API makes Spark easier to use and faster to execute in Java, but there is still little documentation on specific use cases, and many syntax quirks make Scala code difficult to convert to Java. The slides and live coding will present the good, the bad and the ugly moments our Java development team encountered while using Spark.

<!--
**Jury** : Lorsque nous avons commencé à expérimenter avec Spark chez LesFurets.com, nous avons voulu utiliser l'API Java afin de réutiliser notre tooling existant plus facilement, et afin d'être plus à l'aise avec la technologie dans une équipe de développeurs Java. Or nous avons remarqué le manque d'article et de conférences sur l'utilisation de Spark avec Java, surtout d'un point de vue d'un développeur : comment lancer spark à partir de l'IDE ? Comment écrire des tests unitaires et industrialiser le cycle de développement ? Ce talk discute d'un sujet peu abordé mais très utile dans le toolbox de tout développeur Java. Il sera joué à Snowcamp en février et fera parti d'une série d'article à paraître sur le blog de LesFurets.com

**Jury** : This talk is the result of our experience with Spark in our all-Java development team. It sets itself apart by talking about Spark 2.0+ (DataFrame API) and by focusing on Java 8 good practices (with lambda usage), JUnit testing and continuous integration of Spark code. This talk has already been accepted in meetups and one conference (see the speaker experience section) and will be the focus of a series of article to be published on LesFurets.com technical blog.
-->

- 19 avril 2017 (fr) : Breizhcamp @ Rennes [Apache Spark : Deep dive dans l'API Java pour développeur](https://lesfurets.github.io/lesfurets-conferences/html/apache-spark-hands-on-developpeurs-java-breizhcamp.html)
- 9 février 2017 (fr) : Snowcamp @ Grenoble [Apache Spark : Deep dive dans l'API Java pour développeur](https://lesfurets.github.io/lesfurets-conferences/html/apache-spark-hands-on-developpeurs-java-snowcamp.html)
- 31 janvier 2017 (fr) : BBL @ Whoz [Apache Spark : Hands-on et use cases pour développeur Java](https://lesfurets.github.io/lesfurets-conferences/html/apache-spark-hands-on-developpeurs-java-whoz.html)
- 24 janvier 2017 (fr) : BBL @ Murex [Apache Spark : Hands-on et use cases pour développeur Java](https://lesfurets.github.io/lesfurets-conferences/html/apache-spark-hands-on-developpeurs-java-murex.html)

### JOOQ et JOOλ : Comment écrire du code propre dans vos DAO 

Code source pour live code : [https://github.com/lesfurets/lesfurets-conferences/tree/gh-pages/src/jOOQ](https://github.com/lesfurets/lesfurets-conferences/tree/gh-pages/src/jOOQ)

**Abstract** : JOOQ et JOOλ sont des solutions open-source permettant d'intégrer proprement votre application Java avec votre base de données. Quoi de nouveau sous le soleil me diriez-vous ? Après tout la problématique de mapping objet-relationnel est au moins aussi vieille que la plateforme Java. Mais depuis Java 8, JOOQ permet d'utiliser l'API Stream du JDK avec le mapping objet-relationnel, ce qui, couplé avec  JOOλ, a pour effet d'écrire des DAO plus simples et dans un paradigme fonctionnel. Au cours de ce tools in action nous allons vous présenter les avantages que nous pouvons tirer des frameworks JOOQ et JOOλ, par rapport à du JDBC pur sucre,  JPA sans oublier Spring JDBC Template. Cerise sur le gâteau, nous vous indiquerons comment simplement introduire JOOQ et JOOλ dans votre code existant.

**JOOQ and JOOλ : How to write clean code with your Data Access Object** : JOOQ and JOOλ are open-source solutions for integrating your Java application cleanly with your database. So, what's new? After all object-relational mapping is at least as old as the Java platform. But since Java 8, JOOQ allows us to use the Stream API with object-relational mapping, which, coupled with JOOλ, has the effect of writing simpler DAOs in a functional paradigm. During this session we will show you the advantages we can obtain with JOOQ and JOOλ frameworks, compared to pure JDBC, JPA and Spring JDBC Template. And for the icing on the cake, we will show you how to simply introduce JOOQ and JOOλ into your existing code. 


- 23 mai 2017 (en) : BruJUG @ Bruxelles [jOOQ et jOOλ: How to write clean code for your Data Access Objects](https://lesfurets.github.io/lesfurets-conferences/html/JOOQ-and-JOOL-How-to-write-clean-code-with-your-DAO-brujug.html#/)

<!-- 
### Applying Reactive programming for handling server-side concurrency
### Programmation réactive pour gérer la concurrence côté serveur
-->
### Programmation réactive pour l'orchestration de services au sein de la JVM

**Abstract** : 
Lorsque vous effectuez une recherche d'assurance sur LesFurets.com, nous interrogeons jusqu’à 40 partenaires pour offrir un maximum d'offres à nos clients.
Pour collecter ces offres, nous utilisons des patterns à base de locks, threads et files d'attentes en mémoire pour orchestrer des services au sein de la JVM.
Bien que matures, ces constructions sont de très bas niveau et sont sujettes à de nombreuses erreurs :
il manque des abstractions pour aider à mettre en œuvre des politiques pour l'optimisation des ressources, la résilience et la performance.
La programmation réactive propose une approche différente pour aborder ces problèmes de concurrence en permettant aux développeurs de décrire les opérations sur les flux de données.
Dans cette présentation, nous comparons différents patterns pour appliquer une programmation réactive sur un composant critique de notre architecture.
Nous donnons des exemples de différentes API telles que RxJava2, Reactive Streams (Java 9 Flow) et CompletableFutures pour implémenter une orchestration de services tout en garantissant la qualité de services pour les utilisateurs.

**From Legacy to Reactive** : 
When you search for insurance on LesFurets.com, we invoke up to 40 partners to present the best offers to our customers. 
To collect these offers, we use programming patterns based on locks, threads, and in-memory queues to orchestrate services within the Java platform. 
Although mature, these constructs are of very low level and are subject to many errors: They lack suitable abstractions to help implement policies for resource optimization, resilience and performance.
Reactive programming offers an alternative approach for addressing concurrency issues by allowing developers to describe operations on data streams. 
In this presentation, we discuss how we transformed a legacy module of our code base, the service orchestrator, into a reactive component using Reactive Extensions for Java (RxJava). 
We explore various possibilities this reactivity provides us, such as responding to surging requests and optimizing resources, while we continue to guarantee the quality of service for our users.

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

<!--

### Introduction au synthétiseur modulaire et à la musique électronique

**Abstract** : Le synthétiseur est la base de la création de la musique électronique qui était produite, avant l'invention du premier oscillateur à base de système de transistor en 1960, par enregistrements et montages sur bande magnétique. Depuis les premiers synthétiseurs commerciaux lancés par Moog et Buchla au début des années 60, l'évolution du matériel et des techniques de production musicale analogique et été constante, et reste d'actualité aujourd'hui, avec un marché grandissant dans le domaine du synthétiseur modulaire. Nous allons expliquer, et surtout entendre, les différents modules d'un synthétiseur modulaire classique (le Doefper A-100, sorti en 1995), c'est-à-dire les VCO (voltage controled oscilator), les VCF (voltage controlled filter), les VCA (voltage controlled amplifier), les LFO (low frequency oscilattor) et les EG (enveloppe generator).

-->

### JenkinsPipelineUnit: Test your continuous delivery pipeline

**Abstract en:**
At LesFurets.com, we use Jenkins as our workhorse to automate our continuous delivery pipeline. 
Each day we test more than 30 parallel developments and deliver only those which are ready for production. 
From validation to deployment, every step of the pipeline is coded using Jenkins Pipeline DSL and checked into our code base. 
Although coding pipelines using this DSL is very powerful, pipeline scripts can easily get pretty complex. 
That’s why we developed a testing framework, which lets you write unit tests on the configuration and conditional logic of the pipeline code. 
The framework mocks built-in Jenkins commands and job configurations, executing pipeline scripts in a simulated environment. 
It allows to debug job executions and even track regressions between changes. 
In this presentation we present our extensive usage of Jenkins, our open source testing framework and best practices we learnt during our migration to the pipeline DSL.

**Abstract fr :**
Chez LesFurets.com, nous testons en continu plus de 30 développements parallèles et nous livrons ceux qui sont prêts pour la production.
En avril 2016, Jenkins 2.0 a ouvert de multiples possibilités grâce aux pipelines qui permettent de décrire un job en groovy, depuis nous avons migré nos jobs de validation et de déploiement.
Mais comment s’assurer qu’un job pipeline se comportera bien comme attendu ? Pour cela, nous avons mis en place un framework de tests afin de tracer l’exécution d’un pipeline. Il fournit un environnement avec des mocks de commandes internes de Jenkins et simule la configuration d’un job.
On peut ainsi déboguer les exécutions et même suivre les régressions entre deux changements.

Nous présenterons un retour d'expérience de notre utilisation de Jenkins et notre framework de test open-source.
Nous ferons aussi part des difficultés rencontrées lors de notre migration vers le pipeline DSL et comment nous nous en sommes sortis.


* 28 mars 2017 : BGL META (Peterborough) - [JenkinsPipelineUnit: Test your continuous delivery pipeline](https://lesfurets.github.io/lesfurets-conferences/html/jenkins-pipeline-jenkinspipelineunit-bgl-2017.html)
* 23 mai 2017 : Meetup Jenkins (Paris) - [How2Pipeline @CFM](https://lesfurets.github.io/lesfurets-conferences/html/jenkins-pipeline-jenkinspipelineunit-meetup-23-05-2017.html)
* 31 août 2017 : Jenkins World (San Francisco) - TODO

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

Alexandre DuBreuil is a french Canadian software developer living in France working as a Java Architect at LesFurets.com. He really likes to code, talk about code in meetups, user groups and conferences.

Alexandre DuBreuil est un développeur québécois vivant en France et travaillant comme architecte Java chez LesFurets.com. Il aime écrire du code, et parler de code lors de meetups, BBL et conférences.

<!-- 
Apache Spark : Deep dive into the Java API for developers

- February 2017 : Snowcamp @ Grenobles
- January 2017 : Meetup @ Whoz
- January 2017 : Meetup @ Murex

Continuous merge : Reconciling feature branching and continuous delivery

- November 2016 : Meetup @ WorkIT Software
- October 2016 : Java User Group @ Marseilles
- June 2016 : Meetup @ Societe Generale
- January 2016 : Java User Group @ Tours
- December 2015 : Meetup @ Octo
- October 2014 : AgileTour @ Rennes

Software craftmanship

- Mars 2016 : BGL Tech Conference @ London
- November 2015 : Codeurs en Seins @ Rouen 
-->

### Ozan Gunalp [@ozangunalp](https://twitter.com/ozangunalp)

Ingénieur docteur avec 5+ ans d'expérience dans les systèmes distribués, l'Internet des objets et les processus de développement logiciels.
Chez LesFurets.com je m'intéresse à l'amélioration de la qualité et du pipeline de livraison de logiciel.

Ozan has a PhD in Computer Science, with over 5 years of experience in distributed systems, Internet of Things and software development processes. 
He joined LesFurets.com more than a year ago and he is interested in improving the quality and software delivery pipeline.

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

