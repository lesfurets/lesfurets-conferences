# Outils collaboratifs

## Travaux pratiques 1 : git commandes de base

### Introduction

- Concept de working directory (espace de travail, `ls`)
- Concept de dépôt git (base de donnée .git, `git`)
- Concept de commit
- Concept de branche
- Concept de sha1

### Exercices

Configurer git (`config`)

```bash
alexandre@lesfurets:~$ git config --global user.name
Alexandre DuBreuil
alexandre@lesfurets:~$ git config --global user.email
adu@lesfurets.com
```

Initialiser un dépôt vide (`init`)

    git init tp-git
    cd tp-git

Ajouter des commits (`add`, `commit`, `status`)

    echo "Ligne 1" >> fichier1
    echo "Ligne 1" >> fichier2
    echo "Ligne 1" >> fichier3
    ls
    git status
    git add fichier1
    git commit -m "Mon 1e commit"
    git status
    git add fichier2 fichier3
    git commit -m "Mon 2e commit"
    git status

Visualiser l'historique (`log`, `show`)

    git log
    git log --name-status
    git log --oneline --graph --decorate
    git show HEAD
    git show HEAD~1

Modifier des fichiers (`diff`)

    echo "Ligne 2" >> fichier1
    echo "Ligne 2" >> fichier2
    git status
    git diff
    git add fichier1
    git status
    git commit -m "Mon 3e commit"
    git log --name-status
    git status

Retour en arrière (`checkout`, `revert`, `reset`)

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

Utilisation des branches (`branch`, `checkout`)

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

Fusion des branches (`merge`)

    touch fichiermaster
    git add fichiermaster
    git commit -m "Nouveau fichier master"
    git merge --no-edit dev1
    git log
    git log --oneline --graph

## Travaux pratiques 2 : git utilisation en groupe

### Introduction

- Concept de dépôt local / distant
- Concept de branche locale / distante
- Concept de merge
- Concept de pull / push

### Exercices

TODO


