Linus'' law : "Given enough eyes, all bugs are shallow"

## WHY

Impact favorable sur : la qualité / la communicatoin / le savoir / la documentation / le projet

- Détection rapide de bugs (qualité)
    - spécifications -> développement (développement en binôme + TDD) -> code review -> validation fonctionnelle / QA -> production
- Deuxième regard (troisière, ..., nième) a beaucoup de valeur (qualité / savoir)
    - A de la valeur au sein d'une équipe, mais aussi entre équipe
    - Entre junior et senior
- Plus a même d'écrire du bon code si on sait qu'il sera relu (qualité)
    - Les intentions doivent être explicites
    - Si le développeur doit expliquer le code, c'est souvent parce qu'il n'est pas explicite
    - Parler du concept de "auto code review"
- Apprendre de nouvelles manière de faire les choses (savoir / communication)
    - Permet souvent de démarrer la conversation sur certaines parties du code
- Permet de démarrer une discussion autour du code (savoir / communication)
    - Rédaction d'un style guide commun
    - Identification de code smells / anti-pattern spécifiques a l'application
- Force la relecture et l'analyse des métriques de qualité (qualité)
    - Donner du sens aux métriques qualités qui sont souvent peu utilisée :
    - Nombre de tests / couverture de tests
    - Nombre d'erreurs / temps de correction des erreurs / root cause
- Réduction du bus-number (projet / documentation)
    - Force le partage de connaissance, a la fois en explication et en compréhension
    - La code review est une forme de documentation : donne des choix, des pitfalls, etc.

## WHO

Varie en fonction de la nature du code (entre 1 relecteur et oo)

- Développeur
- Relecteur(s)
    - Les relecteurs n'ont pas travaillés sur le code, et n'ont pas été copilotes (s'il y a développement en binôme)
    - Le nombre de relecteur dépend la criticité du code (fonction de la taille et de l'importance du code)
    - Les relecteurs sont sélectionnés selon la méthodologie de travail (en Agile lors du planning, en Kanban lorsque quelqu'un se libère, etc.)
    - Dans certains cas, un relecteur peut être désigné par le développeur (s'il est expert d'un sujet par exemple)
    - Dans certains cas, un relecteur peut être a l'extérieur de l'équipe (idem)
    - S'il y a relecteur désigné, il doit y avoir un relecteur choisi "normalement"

## WHAT

Relire ligne par ligne

- Il n'y a pas de revue de code sans tests unitaires
    - Donne la compréhension nécessaire pour le relecteur
    - Permet au relecteur de savoir rapidement s'il manque des cas (et en suggérer de nouveaux)
    - La revue de code ne trouve pas les mêmes problèmes que les tests unitaires (et inversement)
    - Vérifier la couverture de test pour le nouveau code et le code modifié
- Les anti-patterns
    - Facile de s'entraîner a les détecter rapidement
    - Cachent souvent des problèmes plus graves 
    - TODO lister les plus intéressants
- Les code smells
    - Facile de s'entraîner a les détecter rapidement
    - Cachent souvent des problèmes plus graves 
    - TODO lister les plus intéressants
    - Code dupliqué / réécriture d'une librairie existante
- S'approprier la lisibilité
    - Supprime les arguments sur les accolades ou autres
    - Connaissance collective documenté dans un "guide de style"
    - Réelle source de bug (cf goto fail bug...)
- Les règles métiers
    - Ne pas se limiter a la technique
    - S'assurer que les tests couvrent tout le domaine métier
- Discuter !
    - Parler du code avec le développeur
    - S'il doit "expliquer" le code, c'est probablement parce qu'il n'est pas suffisamment clair...

## HOW

- "Be the change you want to see" - Gandhi
- Démarrer petit dans votre équipe
    - Le plus simple c'est de trouver un ou des "partenaires de crime"
    - Discuter avec ceux qui sont intéressés et valider les hypothèses
    - Noter les consensus dans un "guide de style"
- Commencer a relire et faire relire a l'extérieur de l'équipe

## EXAMPLES / LIVE REVIEW

- Hearthbleed bug : code not tested (but reviewed)
- Goto fail bug : code not tested
- TODO avoir du live review tout au long de la présentation ?

## PITFALLS

- Gold-plating
- Infinite loop

## SOURCES

- http://martinfowler.com/articles/testing-culture.html

We all have knowledge we take for granted, and we often don't realize that it may not be obvious to other people. In the process of making the code understandable by the reviewer, the author is often forced to spell out his assumptions and make the code's intent more obvious. Also, it increases the motiviation to "do things right" given the knowledge that your peers will actually see the code and comment on it openly. This improves code quality and sometimes exposes bugs.

- why style matters ?

        if ((err = ReadyHash(&SSLHashSHA1, &hashCtx)) != 0)
            goto fail;
        if ((err = SSLHashSHA1.update(&hashCtx, &clientRandom)) != 0)
            goto fail;
        if ((err = SSLHashSHA1.update(&hashCtx, &serverRandom)) != 0)
            goto fail;
        if ((err = SSLHashSHA1.update(&hashCtx, &signedParams)) != 0)
            goto fail;
            goto fail;
        if ((err = SSLHashSHA1.final(&hashCtx, &hashOut)) != 0)
            goto fail;

- https://en.wikipedia.org/wiki/Code_smell / https://en.wikipedia.org/wiki/Anti-pattern

## MBO

Ok, y'a pas mal de choses que j'avais envie de voir. Par contre, j'étais bien orienté sur le Who:

- Des devs expérimentés fonctionnellement pour les morceaux de code à valeur business ajoutée
- Des devs expérimentés techniquement pour des morceaux à valeur architecturale ajoutée
- Des devs débutants pour apprendre de nouvelles choses
- Une paire "expérimenté/débutant" pour former, éduquer
- Une paire "dev fonctionnel / dev procédural" pour former, éduquer, l'un ou l'autre ou les deux

Le Why, je le tournerai plus vers l'éducation / remise à niveau / enrichissement de l'équipe:

- "Why buy one 10x developper when you can build 10 of them" (c'est de moi..)
- Faire émerger l'architecture
    - L'injection de dépendances emerge des tests
    - L'assignation rôles/responsabilités emerge de refactorings
    - Tout ceci ne peut prendre tout son sens qu'en prenant du recul, et la code review est un bon moment pour ca, au delà du pair

Et je ferai bien aussi un "Dont":

- Ne pas faire de "shame parade" (prendre un dev malheureux, et montrer son bout de code fautif dans une salle devant tout le monde. ceci n'est pas de la code review, et ce n'est pas bon)
- Ne pas faire de "code réunion" (genre prendre un maximum de gens et passer un maximum de temps a regarder un petit bout de code parce qu'il est critique. s'il est si critique, alors il est petit et testable) (et puis le viol en réunion est une circonstance aggravante)
- Ne pas faire de code review a l'oral, mais prendre des notes, expliquer pourquoi ca nous questionne, pourquoi on n'est pas d'accord, ne serais-ce que pour avoir une référence au moment de corriger, ou de laisser tomber
- Je sais pas si tu as d'autres idées de "Don't"

## ADU

Pour le don't y'a ma section pitfall :

- Gold-plating : trop pointilleux sur la code review
- Infinite loop : retours sur les retours, ou ça en fini plus et y'a rien qui sort

On ne parle pas du tout des outils (et c'est bien), mais ce serait bien de dire pourquoi on ne parle pas des outils :

- La code review ça peut se faire sur un bout de papier
- L'important c'est la culture de la code review, la discussion qui l'entoure, la relecture, etc.
- etc.

## TWITTER

https://twitter.com/neonleif/status/661451757730557953
