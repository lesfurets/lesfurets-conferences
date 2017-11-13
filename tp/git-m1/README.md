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
> Alexandre DuBreuil

git config --global user.email
> adu@lesfurets.com
```

### Exercice 2 : initialiser un dépôt vide (`git init`)

```bash
git init tp-git
> Initialized empty Git repository in tp-git/.git/

cd tp-git
>
```

### Exercice 3 : ajouter des commits (`git add`, `git commit`, `git status`)

```bash
# Initialisation de 3 fichiers avec comme contenu une ligne
echo "Ligne 1" >> fichier1
>

echo "Ligne 1" >> fichier2
>

echo "Ligne 1" >> fichier3
>

ls
> fichier1  fichier2  fichier3
```

```bash
# Ajout du fichier1 dans git un 1e commit
git status
> On branch master
> 
> Initial commit
> 
> Untracked files:
>   (use "git add <file>..." to include in what will be committed)
> 
> 	fichier1
> 	fichier2
> 	fichier3
> 
> nothing added to commit but untracked files present (use "git add" to track)

git add fichier1
>

git status
> On branch master
> 
> Initial commit
> 
> Changes to be committed:
>   (use "git rm --cached <file>..." to unstage)
> 
> 	new file:   fichier1
> 
> Untracked files:
>   (use "git add <file>..." to include in what will be committed)
> 
> 	fichier2
> 	fichier3

git commit -m "Mon 1e commit"
> [master (root-commit) 8e8630d] Mon 1e commit
>  1 file changed, 1 insertion(+)
>  create mode 100644 fichier1

# TODO ajouter fichier2 et fichier3 dans un 2e commit
git add ...
git commit ...
git status
```

### Exercice 4 : visualiser l'historique (`git log`, `git show`)

```bash
git log
git log --name-status
git log --oneline --graph --decorate
git show HEAD
git show HEAD~1
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


