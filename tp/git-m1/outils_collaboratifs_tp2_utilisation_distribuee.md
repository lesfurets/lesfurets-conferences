# Travaux pratiques 2 : git utilisation en groupe

## Introduction

### Le dépôt distant

![remote](https://www.cs.swarthmore.edu/~newhall/unixhelp/gitrepos.gif)
![remote](https://i.stack.imgur.com/UvZ0M.png)

### Le "pull request" (ou "merge request")

![pull request](https://guides.github.com/activities/hello-world/branching.png)

### Le pull / push

![branch](https://git-scm.com/book/en/v2/images/remote-branches-1.png)
![branch](https://git-scm.com/book/en/v2/images/remote-branches-2.png)
![branch](https://git-scm.com/book/en/v2/images/remote-branches-3.png)

## Exercices

- Donner le contexte chez LesFurets.com
- Faire un jeu ou ils doivent reproduire
-- une version par client (2 personnes par client)
-- et une version commune

## Exercice 1 : récupérer le projet git

Faire un clone du depôt git distant https://svn-etu-info-sciences.univ-rouen.fr/git/tp-git. Cela va créer un nouveau dossier "tp-git"

Cette commande est l'équivalent du `git init` du TP précédant

```bash
git clone https://svn-etu-info-sciences.univ-rouen.fr/git/tp-git
cd tp-git
```

Maintenant, vous avez un "remote" qui s'appelle "origin", c'est le dépôt distant

```bash
git remote
# origin
```

Vous êtes sur la branche "master", et le remote a aussi une branche "master", qui s'appelle "origin/master" ou "remotes/origin/master". Vous pouvez récupérer la liste des branches distantes avec `-r` (pour "remote") ou `-a` (pour "all", soit locales et remote).

```bash
git branch
# * master

git branch -a
# * master
#   remotes/origin/master
```

Votre branche "master" est par défaut, une branche de suivie. Vous pouvez faire `git status` pour vous en assurer.
```bash
On branch master
Your branch is up-to-date with 'origin/master'.
nothing to commit, working tree clean
```

Quand vous faites 

- `git pull` (tirer en anglais, pour récupérer de la donnée), vous mergez la branche "origin/master" dans votre branche locale "master"
- `git push` (pousser en anglais, pour envoyer de la donnée), vous mettez à jour sur le dépôt distant le pointeur de branche "origin/master" sur votre dernier commit

Attention : pour faire `git push` vous devez être à jour de la branche "origin/master" (c'est-à-dire faire `git pull` avant)

## Exercice 2 : revue de l'historique

- Quel est le numéro de la dernière pull request ?
- Combien de commit contient la pull request #550 ?
- Quel est le numéro, combien de commit, et quel est l'auteur dans la pull request du commit de merge 8061f2f ?

## Exercice 3 : récupération de versions ultérieures

- Revenir à la version précédente sur le fichier "index.html"
- Un test unitaire a été supprimé dans le commit 5e7b07f, quel est le fichier supprimé ?
- Récupérer le fichier supprimé
- Faire un commit avec le fichier que vous avez récupéré, et le fichier index.html

## Exercice :

