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

## Contexte "Choose a license https://choosealicense.com"

Le code sur lequel vous allez travailler est un petit site web (https://choosealicense.com), dont le code est disponible sur https://github.com/github/choosealicense.com

## Exercice 1 : récupérer le projet git

Faire un clone du depôt git distant https://---------------------.univ-rouen.fr/git/tp-git. Cela va créer un nouveau dossier "tp-git"

Cette commande est l'équivalent du `git init` du TP précédant

```bash
git clone https://---------------------.univ-rouen.fr/git/tp-git
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
git status
# On branch master
# Your branch is up-to-date with 'origin/master'.
# nothing to commit, working tree clean
```

Quand vous faites 

- `git pull` (tirer en anglais, pour récupérer de la donnée), vous mergez la branche "origin/master" dans votre branche locale "master"
- `git push` (pousser en anglais, pour envoyer de la donnée), vous mettez à jour sur le dépôt distant le pointeur de branche "origin/master" sur votre dernier commit

Attention : pour faire `git push` vous devez être à jour de la branche "origin/master" (c'est-à-dire faire `git pull` avant)

## Exercice 2 : revue de l'historique

- Quel est le numéro de la dernière pull request ?
- Combien de commit contient la pull request #550 ?
- Quel est le numéro, combien de commit, et quel est l'auteur dans la pull request du commit de merge `8061f2f` ?

## Exercice 3 : récupération de versions ultérieures

- Quelle est la commande pour revenir à la version précédente sur le fichier "index.html" ?
- Un test unitaire a été supprimé dans le commit `5e7b07f`, quel est le fichier supprimé ?
- Quelle est la commande pour récupérer le fichier supprimé ?

## Exercice 4 : envoyer un commit sur le dépôt distant

Le dossier "\_licenses" contient les licences qui sont affichées sur le site. Vous allez ajouter une license à votre nom (par exemple "alexandre-dubreuil-1.0.txt") et commiter le résultat.

Pour savoir si vous êtes à jour avec le dépôt distant, vous pouvez faire un "git status"

```bash
git status
# On branch master
# Your branch is ahead of 'origin/master' by 1 commit.
#   (use "git push" to publish your local commits)
# nothing to commit, working tree clean
```

Dans ce cas, vous avez un commit en plus en local qui n'est pas sur le distant (`Your branch is ahead of 'origin/master' by 1 commit.`). Pour envoyer votre dernier commit, il faut faire un push. 

```bash
git push
# Username for 'https://---------------------.univ-rouen.fr': dubreale
# Password for 'https://dubreale@---------------------.univ-rouen.fr': 
# Counting objects: 3, done.
# Delta compression using up to 8 threads.
# Compressing objects: 100% (3/3), done.
# Writing objects: 100% (3/3), 332 bytes | 0 bytes/s, done.
# Total 3 (delta 2), reused 0 (delta 0)
# To https://---------------------.univ-rouen.fr/git/tp-git
#    9d9fe7d..93848fa  master -> master
```

On voit le master qui a avancé son pointeur de branche, `9d9fe7d..93848fa master -> master`, donc le dépôt distant pointe maintenant sur votre dernier commit.

**Si vous n'êtes pas le premier à pusher, git va vous demander de faire un `git pull` avant de pouvoir faire un `git push`. Lorsque vous faites un `git push` vous devez être à jour avec le distant, c'est-à-dire que vous devez avoir tous les commits du distant en local.**

```bash
git push
# Username for 'https://---------------------.univ-rouen.fr': dubreale
# Password for 'https://dubreale@---------------------.univ-rouen.fr': 
# To https://---------------------.univ-rouen.fr/git/tp-git
#  ! [rejected]        master -> master (fetch first)
# error: failed to push some refs to 'https://---------------------.univ-rouen.fr/git/tp-git'
# hint: Updates were rejected because the remote contains work that you do
# hint: not have locally. This is usually caused by another repository pushing
# hint: to the same ref. You may want to first integrate the remote changes
# hint: (e.g., 'git pull ...') before pushing again.
# hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```

Si vous voyez `! [rejected] master -> master (fetch first)` vous devez faire un "merge" de la branche distante "origin/master" avec la votre "master". On utilise `git pull`

```bash
git pull
# Username for 'https://---------------------.univ-rouen.fr': dubreale
# Password for 'https://dubreale@---------------------.univ-rouen.fr': 
# remote: Counting objects: 4, done.
# remote: Compressing objects: 100% (2/2), done.
# remote: Total 3 (delta 1), reused 1 (delta 0)
# Unpacking objects: 100% (3/3), done.
# From https://---------------------.univ-rouen.fr/git/tp-git
#    93848fa..13d14c9  master     -> origin/master
# Merge made by the 'recursive' strategy.
#  test | 0
#  1 file changed, 0 insertions(+), 0 deletions(-)
#  create mode 100644 _licenses/john-doe-1.0.txt
```

Puis vous pouvez faire maintenant le `git push`

```bash
git push
# Username for 'https://---------------------.univ-rouen.fr': dubreale
# Password for 'https://dubreale@---------------------.univ-rouen.fr': 
# Counting objects: 4, done.
# Delta compression using up to 8 threads.
# Compressing objects: 100% (4/4), done.
# Writing objects: 100% (4/4), 518 bytes | 0 bytes/s, done.
# Total 4 (delta 2), reused 0 (delta 0)
# To https://---------------------.univ-rouen.fr/git/tp-git
#    13d14c9..819a887  master -> master
```

Regardez dans le dossier "\_licenses"

- Quels fichiers voyez-vous ? Quels fichiers viennent des autres étudiants du TP ?
- Regardez l'historique git, à quoi ressemble le graphe de branche ? Comment repérer les commits des autres étudiants du TP ?

Vous avez donc tous en local sur votre branche "master", le contenu ajouté des autres étudiants.

## Exercice 5 : résoudre les conflits

Modifier le fichier "spec/license\_meta\_spec.rb", dans le tableau "legacy", ajouter votre license à la première ligne.

```ruby
...
        legacy = [
          'alexandre-dubreuil-1.0.txt',
          'afl-3.0',
          'agpl-3.0',
          'artistic-2.0',
          'bsd-2-clause',
          'bsd-3-clause',
...
```

Commiter le fichier et faites un `git push`. Si vous avez besoin de faire un `git pull`, vous allez entrer en conflit, puisque tout le monde a modifié la même ligne.

```bash
git pull
# Username for 'https://--------------------------------.fr': dubreale
# Password for 'https://dubreale@--------------------------------.fr': 
# remote: Counting objects: 7, done.
# remote: Compressing objects: 100% (4/4), done.
# remote: Total 4 (delta 3), reused 0 (delta 0)
# Unpacking objects: 100% (4/4), done.
# From https://--------------------------------.fr/git/tp-git
#    93848fa..abf1ba8  master     -> origin/master
# Auto-merging spec/license_meta_spec.rb
# CONFLICT (content): Merge conflict in spec/license_meta_spec.rb
# Automatic merge failed; fix conflicts and then commit the result.

git status
# On branch master
# Your branch and 'origin/master' have diverged,
# and have 2 and 1 different commits each, respectively.
#   (use "git pull" to merge the remote branch into yours)
# You have unmerged paths.
#   (fix conflicts and run "git commit")
#   (use "git merge --abort" to abort the merge)
# 
# Unmerged paths:
#   (use "git add <file>..." to mark resolution)
# 
# 	both modified:   spec/license_meta_spec.rb
# 
# no changes added to commit (use "git add" and/or "git commit -a")
```

Vous êtes en conflit sur le fichier "both modified: spec/license\_meta\_spec.rb". Vous devez l'ouvrir, garder les deux lignes du conflit, commiter, puis faire un `git push`.

Autrement dit, les lignes suivantes :

```ruby
<<<<<<< HEAD
          'john-doe-1.0.txt',
=======
          'alexandre-dubreuil-1.0.txt',
>>>>>>> abf1ba89021c1ac0571fc04429df5f9fb476dc45
```

Deviennent :

```ruby
          'john-doe-1.0.txt',
          'alexandre-dubreuil-1.0.txt',
```

On garde les 2 lignes parce qu'on souhaite garder la modification des 2 personnes. Chaque résolution de conflit est différente.
