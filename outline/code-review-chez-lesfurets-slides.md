# Garde

# Présentation adu / mbo

# Présentation LF

# Linus law

"Given enough eyes, all bugs are shallow" - Linus Tolvalds

# WHY

## Why : Construction d'une équipe

- Partage de connaissance
- Apprentissage de nouvelles méthodes
- Demarre la converstaion sur le code
- Moyen de prendre du recul

## Why : Documentation (implicite ou explicite)

- Forme de documentation commune
- Identification des code smells
- Base d'argumentaire (style guide)
- TODO reference style guide google

## Why : Qualité

- Auto code review
- Intentions explicites
- Donner sens aux métriques

## Why : Resume

"Contruction d'une equipe qui discute sur la qualité. On cherche a creer une culture d'artisants du code (software craftmans)."

# WHO

## Who : Relecteurs

- Code "business"
- Code "technique"

## Who : Paires

- Paire "expérimenté / débutant"
- Paire "développeur fonctionnel / procédural"
- Les paires apportent des bénéfices différents
- Garder le coaching a l'esprit

## Who : Regles du jeu

- Les relecteurs n'ont pas travaillé sur le code
- Le nombre dépend de la critité du code
- Relecteur sélectionnés selon la méthodologie de travail
- Parfois relecteur désigé par le développeur
- Parfois relecteur externe a l'equipe

## Who : Sommaire

"On cherche a créer une connaissance commune, l'affectation du relecteur n'est pas anodine."

# WHAT

## What : Tests unitaires

- Tests unitaires nécessaires
- Donne le domaine métier du code
- Permet de vérifier la couverture

## What : Compréhension

- Relire toutes les lignes
- Explications sur les lignes incompréhensibles
- Refactoring et retours basés sur les incompréhensions

## What : Anti-pattern et code smells

- Facile a détecter
- Cache souvent des problèmes plus graves
- TODO quelques exemples

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

## What : Resume

"Chaque ligne de code incomprise est une ligne de code ajoutant de la dette technique."

# HOW

# How : Comment procéder ?

- "Be the change you want to see" - Gandhi as code reviewer

# How : La recette de "mémé relectrice"

- Trouver un "partenaire de crime"
- Faire une première revue de code
- Discuter et valider les hypothèses
- Étendre

# How : Outils

- Prendre ce qui marche pour vous
- Commence le plus a poil possible
- Un bout de papier suffit (presque)
- Mais il faut pouvoir documenter les discussions

# How : Resume

"Commencer avec un "crime partner", puis discuter de la discussion issue de la revue de code, pour donner du recul. Étendre graduellement."

# DONT

# Don't

- Pas de "shame parade"
- Pas de réunion de code
- Pas de culture orale
- Pas de sur-relecture

# Don't : Resume

"Se concentrer sur le "quoi" et non sur le "qui" est a la base du partage de connaissance"

# OPENING

- WHY software craftsman / qualite
- WHO affectation du relecteur important
- WAT comprension du code
- HOW commencer avec un "crime partner"
- DNT rentrer centrer sur le quoi

