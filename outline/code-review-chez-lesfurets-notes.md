# Garde

# Présentation adu / mbo

# Présentation LF

# Linus law

"Given enough eyes, all bugs are shallow" - Linus Tolvalds

# WHY

## Why : Construction d'une équipe

- Permet le partage de connaissance, a la fois en explication et en compréhension
- Apprendre de nouvelles manière de faire les choses
- Permet souvent de démarrer la conversation sur certaines parties du code / nouveau code / code legacy
- Tout ceci ne peut prendre tout son sens qu'en prenant du recul, et la code review est un bon moment pour ca, au delà du pair

## Why : Documentation (implicite ou explicite)

- La code review est une forme de documentation commune (explicite ou explicite) : donne des choix, des code smell, des pitfalls, etc.
- Amène a l'identification (implicite ou explicite) de code smells / anti-pattern spécifiques a l'application
- Rédaction d'un style guide commun : base pour l'argumentation

## Why : Code style

- TODO

## Why : Qualité

- Plus a même d'écrire du bon code si on sait qu'il sera relu / parler du concept de "auto code review"
- Les intentions doivent être explicites : si le développeur doit expliquer le code, c'est souvent parce qu'il n'est pas explicite
- Donner du sens aux métriques qualités qui sont souvent peu utilisée : nombre de tests / couverture de tests / nombre d'erreurs / temps de correction des erreurs / root cause

## Why : Resume

"Contruction d'une equipe qui discute sur la qualité. On cherche a creer une culture d'artisants du code (software craftmans)."

# WHO

## Who : Relecteurs

- Des développeurs expérimentés fonctionnellement pour les morceaux de code à valeur business ajoutée
- Des développeurs expérimentés techniquement pour des morceaux à valeur architecturale ajoutée
- TODO

## Who : Paires

- Une paire "expérimenté/débutant" pour former, éduquer
- Une paire "dev fonctionnel / dev procédural" pour former, éduquer, l'un ou l'autre ou les deux
- Toutes les paires sont intéressantes dans leur contexte, et apportent des éléments différents
- cf talk sur le code review ?
- TODO

## Who : Regles du jeu

- Les relecteurs n'ont pas travaillés sur le code, et n'ont pas été copilotes (s'il y a développement en binôme)
- Le nombre de relecteur dépend la criticité du code (fonction de la taille et de l'importance du code)
- Les relecteurs sont sélectionnés selon la méthodologie de travail (en Agile lors du planning, en Kanban lorsque quelqu'un se libère, etc.)
- Dans certains cas, un relecteur peut être désigné par le développeur (s'il est expert d'un sujet par exemple)
- Dans certains cas, un relecteur peut être a l'extérieur de l'équipe (idem)
- S'il y a relecteur désigné, il doit y avoir un relecteur choisi "normalement"

## Who : Sommaire

"On cherche a éduquer et coacher, l'affectation du relecteur n'est pas anodine."

# WHAT

## What : Resume

"Chaque ligne de code incomprise est une ligne de code ajoutant de la dette technique."

## What : Tests unitaires

- Il n'y a pas de revue de code sans tests unitaires : donne la compréhension nécessaire pour le relecteur
- Permet au relecteur de savoir rapidement s'il manque des cas (et en suggérer de nouveaux)
- La revue de code ne trouve pas les mêmes problèmes que les tests unitaires (et inversement)
- Vérifier la couverture de test pour le nouveau code et le code modifié

## What : Compréhension

- Relire toutes les lignes
- Toute ligne incomprehensible / difficile a comprendre, c'est un probleme
- Demander au developpeur d'expliquer les parties difficiles a comprendre 
- Ensuite les refactorer basé sur ces commentaires

## What : Anti-pattern et code smells

- Facile de s'entraîner a les détecter rapidement
- Cachent souvent des problèmes plus graves 
- Code dupliqué / réécriture d'une librairie existante
- Non respect du style
- TODO lister les plus intéressants

## What 

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

- Ajouter des accolades a ce code (pertinance d'avoir un bon style guide)
- Demander si quelqu'un sait ce que c'est ce bug
- Expliquer que c'est un bug present pendant plusieurs mois dans iOS
- TODO trouver source 

# HOW

# How : Resume

"Commencer avec un "crime partner", puis discuter de la discussion issue de la revue de code, pour donner du recul. Étendre graduellement."

# How : Comment procéder ?

- "Be the change you want to see" - Gandhi as code reviewer

# How : La recette de "mémé relectrice"

- Le plus simple c'est de trouver un ou des "partenaires de crime"
- Discuter avec ces personnes et valider les hypothèses
- Noter les consensus dans un "guide de style"
- Commencer a relire et faire relire a l'extérieur de l'équipe

# How : Outils

- Prendre ce qui marche pour vous !
- La code review ça peut (presque) se faire sur un bout de papier
- L'important c'est la culture de la code review, la discussion qui l'entoure, la relecture, etc.

# DONT

# Don't : Resume

"Se concentrer sur le "quoi" et non sur le "qui" est a la base du partage de connaissance"

# Don't : shame

- Ne pas faire de "shame parade" (prendre un dev malheureux, et montrer son bout de code fautif dans une salle devant tout le monde. ceci n'est pas de la code review, et ce n'est pas bon)
- Ne pas faire de "code réunion" (genre prendre un maximum de gens et passer un maximum de temps a regarder un petit bout de code parce qu'il est critique. s'il est si critique, alors il est petit et testable) (et puis le viol en réunion est une circonstance aggravante)
- Ne pas faire de code review a l'oral, mais prendre des notes, expliquer pourquoi ca nous questionne, pourquoi on n'est pas d'accord, ne serais-ce que pour avoir une référence au moment de corriger, ou de laisser tomber
- Ne pas passer trop de temps a le faire, ni passer des revues sur des revues qui ne terminent plus, c'est deja assez chronophage : rester pragmatique 

# OPENING

- WHY software craftsman / qualite
- WHO affectation du relecteur important
- WAT comprension du code
- HOW commencer avec un "crime partner"
- DNT rentrer centrer sur le quoi

