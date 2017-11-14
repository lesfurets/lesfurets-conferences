# Travaux pratiques 1 : git commandes de base

## Introduction

### Le working directory (espace de travail, `ls`)

![working dir](https://git-scm.com/book/en/v2/images/areas.png)

### Le dépôt git (base de donnée .git, `git`)

![repository](https://git-scm.com/book/en/v2/images/snapshots.png)

### Le commit (`git commit`)

![commit](https://git-scm.com/book/en/v2/images/lifecycle.png)

### Les branches

![branches](https://git-scm.com/book/en/v2/images/branch-and-history.png)

## Exercice 1 : configurer git (`git config`)

Les commit dans git contienne votre nom et mail, ce sera important pour le TP2

```bash
git config --global user.name
# Alexandre DuBreuil

git config --global user.email
# adu@lesfurets.com
```

## Exercice 2 : initialiser un dépôt vide (`git init`)

Pour démarrer un nouveau dépôt, utiliser `git init`, puis `cd` pour entrer dans le répertoire créé par git.

```bash
git init tp-git
# Initialized empty Git repository in tp-git/.git/

cd tp-git
```

## Exercice 3 : ajouter des commits (`git add`, `git commit`, `git status`)

Utiliser `echo` pour créer 3 nouveaux fichiers avec comme contenu une ligne "Ligne 1"

```bash
echo "Ligne 1" >> fichier1
echo "Ligne 1" >> fichier2
echo "Ligne 1" >> fichier3

ls
# fichier1  fichier2  fichier3
```

Avec `git status`, git vous montre qu'il y a 3 nouveaux fichier dans votre répertoire de travail qui sont "untracked" ou inconnu.

```bash
git status
# On branch master
# 
# Initial commit
# 
# Untracked files:
#   (use "git add <file>..." to include in what will be committed)
# 
# 	fichier1
# 	fichier2
# 	fichier3
# 
# nothing added to commit but untracked files present (use "git add" to track)
```

Pour ajouter ces fichiers au "staging", il faut utiliser la commande `git add`. Attention: cela n'ajoute pas le fichier à git, pour se faire il faut faire un "commit".

La commande `git status` vous montre l'état de votre dépôt

```bash
git add fichier1
git status
# On branch master
# 
# Initial commit
# 
# Changes to be committed:
#   (use "git rm --cached <file>..." to unstage)
# 
# 	new file:   fichier1
# 
# Untracked files:
#   (use "git add <file>..." to include in what will be committed)
# 
# 	fichier2
# 	fichier3
```

Le "staging" est la partie notée par "changes to be commited". Pour créer un nouveau commit, utiliser la commande `git commit`. À partir du moment ou un fichier est dans un commit, il est persisté à jamais dans git.

```bash
git commit -m "Mon 1e commit"
# [master (root-commit) 8e8630d] Mon 1e commit
#  1 file changed, 1 insertion(+)
#  create mode 100644 fichier1
```

**TODO:** Ajouter fichier2 et fichier3 dans un 2e commit, jusqu'à ce que git affiche "working tree clean", ce qui veut dire que le dépôt git contient tous les fichiers qui sont dans votre répertoire de travail.

```bash
git add ...
git commit ...
git status
# On branch master
# nothing to commit, working tree clean
```

## Exercice 4 : visualiser l'historique (`git log`, `git show`)

Vous avez déjà fait 2 commits et la commande `git log` vous permet de les voir

```bash
git log
# commit 888f4ecca3f04f6dc8ef5f314b279078a5086092
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:21:53 2017 +0100
# 
#     Mon 2e commit
# 
# commit 8e8630d691ada27638084dcb1e5c4f55b0ef451d
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:12:21 2017 +0100
# 
#     Mon 1e commit
```

L'option `--name-status` donne la liste des fichiers modifiés (le A préfixé veut dire "added", vous avez aussi M pour "modified" et D pour "deleted")

```bash
git log --name-status
# commit 888f4ecca3f04f6dc8ef5f314b279078a5086092
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:21:53 2017 +0100
# 
#     Mon 2e commit
# 
# A       fichier2
# A       fichier3
# 
# commit 8e8630d691ada27638084dcb1e5c4f55b0ef451d
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:12:21 2017 +0100
# 
#     Mon 1e commit
# 
# A       fichier1
```

```bash
git log --oneline --graph --decorate
# * 888f4ec (HEAD -> master) Mon 2e commit
# * 8e8630d Mon 1e commit
```

La commande `git show` permet de voir le contenu des modifications, les lignes ajoutées sont préfixées d'un +, les lignes supprimées sont préfixées d'un - (ce sont les seules modifications possibles)

Le paramètre HEAD veut dire "commit courant"

```bash
git show HEAD
# commit 888f4ecca3f04f6dc8ef5f314b279078a5086092
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:21:53 2017 +0100
# 
#     Mon 2e commit
# 
# diff --git a/fichier2 b/fichier2
# new file mode 100644
# index 0000000..1aafa9c
# --- /dev/null
# +++ b/fichier2
# @@ -0,0 +1 @@
# +Ligne 1
# diff --git a/fichier3 b/fichier3
# new file mode 100644
# index 0000000..1aafa9c
# --- /dev/null
# +++ b/fichier3
# @@ -0,0 +1 @@
# +Ligne 1
```

La syntaxe `HEAD~1` permet de revenir un commit en arrière (HEAD est le commit courant, HEAD\~1 est le commit précédent, HEAD\~2 est le commit d'avant, etc.)

```bash
git show HEAD~1
# commit 8e8630d691ada27638084dcb1e5c4f55b0ef451d
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:12:21 2017 +0100
# 
#     Mon 1e commit
# 
# diff --git a/fichier1 b/fichier1
# new file mode 100644
# index 0000000..1aafa9c
# --- /dev/null
# +++ b/fichier1
# @@ -0,0 +1 @@
# +Ligne 1
```

## Exercice 5 : modifier des fichiers (`git diff`)

On ajoute une ligne aux fichier1 et fichier2 avec `echo`

```bash
echo "Ligne 2" >> fichier1
echo "Ligne 2" >> fichier2
git status
# On branch master
# Changes not staged for commit:
#   (use "git add <file>..." to update what will be committed)
#   (use "git checkout -- <file>..." to discard changes in working directory)
# 
# 	modified:   fichier1
# 	modified:   fichier2
# 
# no changes added to commit (use "git add" and/or "git commit -a")
```

La commande `git diff` permet de voir les modifications qu'on a fait (utile avant le commit), c'est le même affichage que la commande `git show` de l'exercice précédent.

```bash
git diff
# diff --git a/fichier1 b/fichier1
# index 1aafa9c..304294e 100644
# --- a/fichier1
# +++ b/fichier1
# @@ -1 +1,2 @@
#  Ligne 1
# +Ligne 2
# diff --git a/fichier2 b/fichier2
# index 1aafa9c..304294e 100644
# --- a/fichier2
# +++ b/fichier2
# @@ -1 +1,2 @@
#  Ligne 1
# +Ligne 2
```

On ajoute le fichier1 dans un nouveau commit pour l'exercice suivant

```bash
git add fichier1
git commit -m "Mon 3e commit"
# [master 59c88f8] Mon 3e commit
#  1 file changed, 1 insertion(+)
```

## Exercice 6 : retour en arrière (`git checkout`, `git revert`, `git reset`)

Utiliser `git checkout` pour récupérer la dernière version d'un fichier (si le fichier est modifié, on revient à la version du dernier commit)

```bash
cat fichier2
# Ligne 1
# Ligne 2

git checkout fichier2

cat fichier2
# Ligne 1
```

Utiliser `git revert` pour créer un commit qui est l'inverse du commit (les lignes ajoutées seront enlevées et vice-versa)

```bash
touch poubelle
ls
# fichier1  fichier2  fichier3  poubelle

git add poubelle
git commit -m poubelle
# [master 3012558] poubelle
#  1 file changed, 0 insertions(+), 0 deletions(-)
#  create mode 100644 poubelle

git revert --no-edit HEAD
# [master b010b1b] Revert "poubelle"
#  1 file changed, 0 insertions(+), 0 deletions(-)
#  delete mode 100644 poubelle

git log
# commit b010b1b337739fdb644e0161ebaba0e8de78f34f
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:56:06 2017 +0100
# 
#     Revert "poubelle"
#     
#     This reverts commit 301255866e8f06f12fad3e709e5f8e63076e7bc4.
# 
# commit 301255866e8f06f12fad3e709e5f8e63076e7bc4
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:55:38 2017 +0100
# 
#     poubelle
# 
# commit 59c88f86b6b64c6f016bb6e078d520d89826dfb7
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:41:17 2017 +0100
# 
#     Mon 3e commit
# 
# ...

ls
# fichier1  fichier2  fichier3
```

Utiliser `git reset` pour supprimer le commit (attention : cette opération parfois est réversible, mais avec des commandes difficiles à utiliser, éviter l'usage)

```bash
git reset --hard HEAD~1
# HEAD is now at 3012558 poubelle

ls
# fichier1  fichier2  fichier3  poubelle
```

On est de retour sur le commit avec le fichier "poubelle"

```bash
git reset --hard HEAD~1
# HEAD is now at 59c88f8 Mon 3e commit

git log
# commit 59c88f86b6b64c6f016bb6e078d520d89826dfb7
# Author: Alexandre DuBreuil <adu@lesfurets.com>
# Date:   Mon Nov 13 17:41:17 2017 +0100
# 
#     Mon 3e commit
#  ...
```

On est bien revenu sur le 3e commit

## Exercice 7 : utilisation des branches (`git branch`, `git checkout`)

Les branches permettent de développer des nouvelles fonctionnalités de manière indépendante, la création se fait avec la commande `git branch`

Vous pouvez les voir comme des copies de votre espace de travail, entre lesquelles vous pouvez basculer rapidement, avec la commande `git checkout`

```bash
git branch develop
git branch
#   develop
# * master

git checkout develop
# Switched to branch 'develop'
git branch
# * develop
#   master
```

Pour l'instant, les 2 branches sont identiques, mais les modifications de l'une ne vont pas impacter l'autre.

On ajoute un fichier "fichierdev" dans la branche courante, soit "develop", dans un nouveau commit

```bash
touch fichierdev
git add fichierdev
git commit -m "Nouveau fichier dev 1"
# [develop c1fa6e3] Nouveau fichier dev 1
#  1 file changed, 0 insertions(+), 0 deletions(-)
#  create mode 100644 fichierdev
```

On remarque que ce commit est présent dans la branche courante "develop" mais pas dans la branche "master"

```bash
git log --oneline
# c1fa6e3 Nouveau fichier dev
# 59c88f8 Mon 3e commit
# 888f4ec Mon 2e commit
# 8e8630d Mon 1e commit

git log --oneline master
# 59c88f8 Mon 3e commit
# 888f4ec Mon 2e commit
# 8e8630d Mon 1e commit
```

Ce qui veut dire que le nouveau fichier "fichierdev" est présent dans la branche "develop", mais pas dans master

```bash
ls
# fichier1  fichier2  fichier3  fichierdev

git checkout master
# Switched to branch 'master'

ls
# fichier1  fichier2  fichier3
```

Le fichier "fichierdev" n'est pas présent dans votre répertoire de travail

## Exercice 8 : fusion des branches (`git merge`)

La branche "develop" a plus de commit que la branche master, comment fait-on pour rassembler l'historique ?

On crée un nouveau commit sur la branche "master", on aura donc 2 branches divergeantes comme dans cet exemple (remplacer "testing" par "develop")

![split](https://git-scm.com/book/en/v2/images/advance-master.png)

```bash
touch fichiermaster
git add fichiermaster
git commit -m "Nouveau fichier master"
# [master 509f5a4] Nouveau fichier master
#  1 file changed, 0 insertions(+), 0 deletions(-)
#  create mode 100644 fichiermaster
```

Pour fusionner l'historique on utilise la commande `git merge`, en passant comme argument l'autre (ou les autres) branche à fusionner

```bash
git merge --no-edit develop
# Merge made by the 'recursive' strategy.
#  fichierdev | 0
#  1 file changed, 0 insertions(+), 0 deletions(-)
#  create mode 100644 fichierdev

git log --oneline --graph --decorate
# *   f5cf4f0 (HEAD -> master) Merge branch 'develop'
# |\  
# | * c1fa6e3 (develop) Nouveau fichier dev
# * | 509f5a4 Nouveau fichier master
# |/  
# * 59c88f8 Mon 3e commit
# * 888f4ec Mon 2e commit
# * 8e8630d Mon 1e commit
```

On voit que l'historique des branches s'est séparé, puis fusionné en avec un commit de merge (le commit nommé "Merge branch 'develop'")

![merge](https://git-scm.com/book/en/v2/images/basic-merging-2.png)

