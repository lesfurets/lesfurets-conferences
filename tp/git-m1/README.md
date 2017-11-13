# Outils collaboratifs

## Travaux pratiques 1 : git commandes de base

### Introduction

- Concept de working directory (espace de travail, `ls`)
- Concept de dépôt git (base de donnée .git, `git`)
- Concept de commit
- Concept de branche
- Concept de sha1

### Exercice 1 : configurer git (`git config`)

```bash
git config --global user.name
# Alexandre DuBreuil

git config --global user.email
# adu@lesfurets.com
```

### Exercice 2 : initialiser un dépôt vide (`git init`)

```bash
git init tp-git
# Initialized empty Git repository in tp-git/.git/

cd tp-git
```

### Exercice 3 : ajouter des commits (`git add`, `git commit`, `git status`)

```bash
echo "Ligne 1" >> fichier1
echo "Ligne 1" >> fichier2
echo "Ligne 1" >> fichier3

ls
# fichier1  fichier2  fichier3
```

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

git commit -m "Mon 1e commit"
# [master (root-commit) 8e8630d] Mon 1e commit
#  1 file changed, 1 insertion(+)
#  create mode 100644 fichier1
```

**TODO:** Ajouter fichier2 et fichier3 dans un 2e commit

```bash
git add ...
git commit ...
git status
# On branch master
# nothing to commit, working tree clean
```

### Exercice 4 : visualiser l'historique (`git log`, `git show`)

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

### Exercice 5 : modifier des fichiers (`git diff`)

```bash
echo "Ligne 2" >> fichier1
echo "Ligne 2" >> fichier2
git status
git diff
git add fichier1
git status
git commit -m "Mon 3e commit"
git log --name-status
git status
```

### Exercice 6 : retour en arrière (`git checkout`, `git revert`, `git reset`)

```bash
cat fichier2
git checkout fichier2
cat fichier2
touch poubelle
ls
git add poubelle
git commit -m poubelle
git revert --no-edit HEAD
git log
ls
git reset --hard HEAD~1
git log
ls
git reset --hard HEAD~1
git log
ls
```

### Exercice 7 : utilisation des branches (`git branch`, `git checkout`)

```bash
git branch dev1
git branch
git checkout dev1
git log
touch fichierdev1
git add fichierdev1
git commit -m "Nouveau fichier dev 1"
git log
git log master
git checkout master
git log
ls
git branch
```

### Exercice 8 : fusion des branches (`git merge`)

```bash
touch fichiermaster
git add fichiermaster
git commit -m "Nouveau fichier master"
git merge --no-edit dev1
git log
git log --oneline --graph
```

## Travaux pratiques 2 : git utilisation en groupe

### Introduction

- Concept de dépôt local / distant
- Concept de branche locale / distante
- Concept de merge
- Concept de pull / push

### Exercices

TODO


