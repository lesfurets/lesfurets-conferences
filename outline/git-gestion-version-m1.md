# GIT

## Plan

## VCS : Gestion versions

### Définition VCS

- "Revision control system" ou "revision system"
- "La gestion de versions (en anglais version control ou revision control) consiste à maintenir l'ensemble des versions d'un ou plusieurs fichiers (généralement en texte)."
- "Essentiellement utilisée dans le domaine de la création de logiciels, elle concerne surtout la gestion des codes source."
- Commence a être utilisé autrement : https://github.com/steeve/france.code-civil/commit/b805ecf05a86162d149d3d182e04074ecf72c066 (code civil, modifications pour le mariage pour tous) / architectes (Open BIM) / etc
- img github-code-civil-france-01.png

### Type VCS

- Décentralisés vs centralisé
- Centralisé : gestion de source "historique" avec CVS et SVN
- Décentralisé : popularisé au début des années 2000, prend son ampleur avec git

### Historique

- Début vers 1972 (Bell labs : SCCS)
- Beaucoup de développements vers 1990
- Open source / propriétaires
- ref : pptx historique

### Décentralisé

- img git book

### Centralisé

- img git book

### Utilisation avec l'usine logicielle

- ref : pptx jenkins

### SVN

- A faire ?

## Git

### Historique git

- Modifications linux de 1991 a 2002 sous forme de patch
- Passage a un DVCS propriétaire Bitkeeper en 2002
- Relations tendues avec les développeurs de Bitkeeper en 2005
- Linus Tolvalds (et la communauté linux) développent git

### Objectifs

- Vitesse
- Conception simple
- Support pour les dévelopements non linéaires
- Complètement distribué
- Peut gérer d'énormes projets (noyau linux, code base google)

### Très optimisé

- img code base google

### Stockage des deltas

- :) stockage des données (bof)
- :( très lent 
- ref img commits delta

### Stockage des instantanés

- :) très rapide
- ref img commits full

### Caractéristiques GIT

- Opérations presques toutes locales
- Gestion de l'intégrité (SHA-1)
- Append only (ajout seulement)

### Gestion modale

- ref img working stage

## Commandes de base

### Votre meilleur ami

$ git help
usage: git [--version] [--help] [-C &ltpath&gt] [-c name=value]
           [--exec-path[=&ltpath&gt]] [--html-path] [--man-path] [--info-path]
           [-p|--paginate|--no-pager] [--no-replace-objects] [--bare]
           [--git-dir=&ltpath&gt] [--work-tree=&ltpath&gt] [--namespace=&ltname&gt]
           &ltcommand&gt [&ltargs&gt]

The most commonly used git commands are:
   add        Add file contents to the index
   bisect     Find by binary search the change that introduced a bug
...

### Pour toutes les commandes

$ git help add
GIT-ADD(1)                                                   Git Manual                                                  GIT-ADD(1)

NAME
       git-add - Add file contents to the index

SYNOPSIS
       git add [-n] [-v] [--force | -f] [--interactive | -i] [--patch | -p]
                 [--edit | -e] [--[no-]all | --[no-]ignore-removal | [--update | -u]]
                 [--intent-to-add | -N] [--refresh] [--ignore-errors] [--ignore-missing]
                 [--] [&ltpathspec&gt...]

DESCRIPTION
       This command updates the index using the current content found in the working tree, to prepare the content staged for the
       next commit. It typically adds the current content of existing paths as a whole, but with some options it can also be used
...

### Démarrer un repo

$ git init .
Initialized empty Git repository in /home/dubreuia/Documents/project/git/src/.git/
$ git add git-gestion-version-m1.html
$ git commit -m "Ajout presentation HTML"
[master (root-commit) 876c849] Ajout presentation HTML
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 git-gestion-version-m1.html

### Cloner un repo

$ git clone https://github.com/dubreuia/lesfurets-conferences.git
Cloning into 'lesfurets-conferences'...
remote: Counting objects: 547, done.
remote: Total 547 (delta 0), reused 0 (delta 0), pack-reused 547
Receiving objects: 100% (547/547), 39.13 MiB | 1.09 MiB/s, done.
Resolving deltas: 100% (234/234), done.
Checking connectivity... done.

### États d'un fichier

- ref img untracked-unmodified-modified-staged

### Statut d'un repo

$ git status
On branch master
Untracked files:
  (use "git add &ltfile&gt..." to include in what will be committed)

	github-code-civil-france-01.jpg
	google-repository-02.jpg

nothing added to commit but untracked files present (use "git add" to track)

### Ajout des fichiers au suivi de version

$ git add github-code-civil-france-01.jpg 
$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD &ltfile&gt..." to unstage)

	new file:   github-code-civil-france-01.jpg

Untracked files:
  (use "git add &ltfile&gt..." to include in what will be committed)

	google-repository-02.jpg

### Modifier un fichier

$ vim git-gestion-version-m1.html 
$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD &ltfile&gt..." to unstage)

	new file:   github-code-civil-france-01.jpg

Changes not staged for commit:
  (use "git add &ltfile&gt..." to update what will be committed)
  (use "git checkout -- &ltfile&gt..." to discard changes in working directory)

	modified:   git-gestion-version-m1.html

Untracked files:
  (use "git add &ltfile&gt..." to include in what will be committed)

	google-repository-02.jpg

### L'ajouter ensuite a l'index

$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD &ltfile&gt..." to unstage)

	modified:   git-gestion-version-m1.html
	new file:   github-code-civil-france-01.jpg

Untracked files:
  (use "git add &ltfile&gt..." to include in what will be committed)

	google-repository-02.jpg

### Ignorer des fichiers

$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD &ltfile&gt..." to unstage)

	modified:   git-gestion-version-m1.html
	new file:   github-code-civil-france-01.jpg

Untracked files:
  (use "git add &ltfile&gt..." to include in what will be committed)

	.outline.md.swp
	google-repository-02.jpg

$ echo "\*.swp" &gt&gt .gitignore
dubreuia@dubreuia:~/Documents/project/git/src$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD &ltfile&gt..." to unstage)

	modified:   git-gestion-version-m1.html
	new file:   github-code-civil-france-01.jpg

Untracked files:
  (use "git add &ltfile&gt..." to include in what will be committed)

	.gitignore

### Voir les différences ...

$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD &ltfile&gt..." to unstage)

	modified:   git-gestion-version-m1.html
	new file:   github-code-civil-france-01.jpg

Changes not staged for commit:
  (use "git add &ltfile&gt..." to update what will be committed)
  (use "git checkout -- &ltfile&gt..." to discard changes in working directory)

	modified:   git-gestion-version-m1.html

### ... dans les fichiers modifiés

$ git diff
diff --git a/git-gestion-version-m1.html b/git-gestion-version-m1.html
index a839173..d0d1147 100644
--- a/git-gestion-version-m1.html
+++ b/git-gestion-version-m1.html
@@ -1,4 +1,4 @@
-&lthtml&gt
+&lt!DOCTYPE html&gt
 &lthead&gt
 &lt/head&gt

### ... dans les fichiers de l'index

$ git diff --staged
diff --git a/git-gestion-version-m1.html b/git-gestion-version-m1.html
index e69de29..a839173 100644
--- a/git-gestion-version-m1.html
+++ b/git-gestion-version-m1.html
@@ -0,0 +1,5 @@
+&lthtml&gt
+&lthead&gt
+&lt/head&gt
+&ltbody&gt
+&lt/body&gt
diff --git a/github-code-civil-france-01.jpg b/github-code-civil-france-01.jpg
new file mode 100644
index 0000000..8fe5d84
Binary files /dev/null and b/github-code-civil-france-01.jpg differ

### Valider les modifications

$ git commit -m "Ajouter la structure HTML"
[master 19b4b66] Ajouter la structure HTML
 2 files changed, 5 insertions(+)
 create mode 100644 github-code-civil-france-01.jpg
$ git status
On branch master
Changes not staged for commit:
  (use "git add &ltfile&gt..." to update what will be committed)
  (use "git checkout -- &ltfile&gt..." to discard changes in working directory)

	modified:   git-gestion-version-m1.html

Untracked files:
  (use "git add &ltfile&gt..." to include in what will be committed)

	google-repository-02.jpg

### Effacter des fichiers

$ git rm poubelle.txt 
rm 'poubelle.txt'
$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD &ltfile&gt..." to unstage)

	deleted:    poubelle.txt

### Déplacer des fichiers

- Support partiel dans git (basé sur la quantité de contenu modifié)

$ git mv git-gestion-version-m1.html git-gestion-version-m1-super-presentation.html 
$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD &ltfile&gt..." to unstage)

	renamed:    git-gestion-version-m1.html -&gt git-gestion-version-m1-super-presentation.html

### Visualiser l'historique

$ git log
commit 19b4b66ac5fd3483e549e300656f1de2618891c4
Author: Alexandre DuBreuil &ltdubreuil.alex@gmail.com&gt
Date:   Sun Nov 29 18:52:37 2015 +0100

    Ajouter la structure HTML

commit 876c849d8e41e1fdb59ae71bce6d94cc47242663
Author: Alexandre DuBreuil &ltdubreuil.alex@gmail.com&gt
Date:   Sun Nov 29 18:24:34 2015 +0100

    Ajout presentation HTML

### Enlever de l'index (git reset)

$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD &ltfile&gt..." to unstage)

	modified:   git-gestion-version-m1.html

$ git reset HEAD git-gestion-version-m1.html
Unstaged changes after reset:
M	git-gestion-version-m1.html
$ git status
On branch master
Changes not staged for commit:
  (use "git add &ltfile&gt..." to update what will be committed)
  (use "git checkout -- &ltfile&gt..." to discard changes in working directory)

	modified:   git-gestion-version-m1.html

### Réinitialiser un fichier (git checkout)

- Attention : perte de donnée possible !

$ git status
On branch master
Changes not staged for commit:
  (use "git add &ltfile&gt..." to update what will be committed)
  (use "git checkout -- &ltfile&gt..." to discard changes in working directory)

	modified:   git-gestion-version-m1.html

$ git checkout -- git-gestion-version-m1.html
$ git status
On branch master

### Dépôts distants / vs dépots locaux

- Jusqu'a présent, on a travaillé qu'en local
- Il faut pouvoir récupérer / envoyer des commits
- On récupère toujours tout (copie dépot) avec le fetch
- On applique ce qu'on veut avec le pull (fetch + merge)
- On pousse a partir d'un commit avec le push

### Afficher les dépôts distants

$ git clone https://github.com/dubreuia/lesfurets-conferences.git
Cloning into 'lesfurets-conferences'...
remote: Counting objects: 547, done.
remote: Total 547 (delta 0), reused 0 (delta 0), pack-reused 547
Receiving objects: 100% (547/547), 39.13 MiB | 760.00 KiB/s, done.
Resolving deltas: 100% (234/234), done.
Checking connectivity... done.
$ cd lesfurets-conferences/
$ git remote
origin

### Récupérer les commits d'un repo

- Ne les applique pas (fetch vs pull)

$ git fetch origin
remote: Counting objects: 43, done.
remote: Compressing objects: 100% (36/36), done.
remote: Total 43 (delta 10), reused 31 (delta 5)
Dépaquetage des objets: 100% (43/43), fait.
Depuis https://github.com/dubreuia/lesfurets-conferences.git
* [nouvelle branche] master
-&gt origin/master
* [nouvelle branche] ticgit
-&gt origin/ticgit

### Appliquer les commits d'un repo

- Fait un fetch suivi d'un checkout
- Va éventuellement merger les modifications

$ git status
On branch gh-pages
Your branch is behind 'origin/gh-pages' by 1 commit, and can be fast-forwarded.
  (use "git pull" to update your local branch)
nothing to commit, working directory clean
$ git pull origin
Updating 4c4ef8a..cffa4b1
Fast-forward
 code-review-chez-lesfurets.html | 2 +-
 1 file changed, 1 insertion(+), 1 deletion(-)

### Autres commandes

- git tag : Étiquetage d'un commit
- git show : Contenu d'un commit
- git grep : Recherche d'un commit
- git reset : Retour a un commit
- git reset : Trouver qui a ajouté une ligne

## Branches

### Un arbre de fichiers binaires

- ref commit-blob

### Un arbre de commits

- ref commit-tree

### Le pointeur HEAD

- ref commit-head

### Créer une nouvelle branche

$ git branch testing

- ref branch ajout testing

### Changer de branches

$ git checkout testing
Switched to branch 'testing'

- ref branch checkout testing

### Déplacement du pointeur testing

$ vim git-gestion-version-m1.html 
$ git commit -a -m "Ajout experimental"
[testing 64ff99b] Ajout experimental
 1 file changed, 1 insertion(+), 1 deletion(-)

- ref branch commit testing

### Ajout d'un commit sur master

- Il faut revenir sur master git checkout master
- Puis faire un commit

- ref branch commit master

### L'arbre de commit a divergé entre les 2 branches

$ git log --graph --oneline --all
* a2d71b4 Commit sur branche master
| * dc1d4a9 Ajout d'un commit sur testing
|/  
* 19b4b66 Ajouter la structure HTML
* 876c849 Ajout presentation HTML

- ref branch diverge 

## Fusion

### Types de fusion

- Plusieurs types : soit un merge, soit un "fast-forward", ...
- Fast-forward : pas de conflit possible, on ajoute ce qui manque
- Merge : Conflit possible a resoudre a la main

### Avant la fusion

- ref image branch avant fusion

### Effectuer la fusion

- Se positionner sur la branche de base (master)
- Merger l'autre branche (iss53) dans la branche de base

$ git checkout master
$ git merge fusion-pas-de-conflit 
Updating a2d71b4..bea04e9
Fast-forward
 pas-de-conflit | 0
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 pas-de-conflit

### Commit de merge

- ref branch merge

### Conflits de merge

- Lorsque la même ligne est modifiée, git ne peut pas merger
- Il faut le faire a la main

$ git merge testing 
Auto-merging git-gestion-version-m1.html
CONFLICT (content): Merge conflict in git-gestion-version-m1.html
Automatic merge failed; fix conflicts and then commit the result.

### Marquage du conflit par git

&lt&lt&lt&lt&lt&lt&lt HEAD
&lt!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"&gt 
=======
&lt!DOCTYPE html&gt
&gt&gt&gt&gt&gt&gt&gt testing
&lthead&gt
&lt/head&gt
&ltbody&gt
&lt/body&gt

### Résolution du conflit

&lt!DOCTYPE html&gt
&lthead&gt
&lt/head&gt
&ltbody&gt
&lt/body&gt

$ git add git-gestion-version-m1.html
$ git commit

Merge branch 'testing'

Conflicts:
	git-gestion-version-m1.html

### Gestion des branches distantes

- Pour l'instant, on a traité que des branches locales
- Les pointeurs de branches distantes sont préfixées par le nom du serveur

- ref branche distante

### On travaille en local

- Le pointeur de branche master avance
- Mais pas le pointeur de branche origin/master

- ref branche master local

### ... mais le serveur avance aussi

$ git fetch

- ref branche master remote

### On ne peut plus pousser !

$ git push 
To https://github.com/dubreuia/conferences.git
 ! [rejected]        gh-pages -&gt gh-pages (non-fast-forward)
error: failed to push some refs to 'https://github.com/dubreuia/conferences.git'
hint: Updates were rejected because the tip of your current branch is behind
hint: its remote counterpart. Integrate the remote changes (e.g.
hint: 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

### D'abord récupérer les données

- Rappel : le pull est un fetch + merge

$ git pull # git fetch && git merge origin/master
Merge branch 'gh-pages' of https://github.com/dubreuia/conferences into gh-pages

### Retour a la normale

$ git log --graph --oneline
*   988e120 Merge branch 'gh-pages' of https://github.com/dubreuia/conferences into gh-pages
|\  
| * af401f2 Add architecture slide
* | f9a1aef nouveau commit
|/  
* 5faf3ff Add concert page and correct logo

### Au lieu du merge : rebase

- Copie les commit du distant avant les commits locaux
- Utile pour avoir un historique sans "branchement"
- Fonctionnalitée avancée

$ git pull --rebase # git fetch && git rebase origin/master
First, rewinding head to replay your work on top of it...
Applying: nouveau commit

### Merge vs rebase

- ref merge vs rebase
- ref rebase vs merge

## fin
