# git-octopus demo

    # Nous avons deux depôts de code, soit studies et features
    git branch -a | grep studies
    git branch -a | grep features

    # Exécuter git-octopus
    git octopus
    git octopus features/*
    git octopus -n features/*

    # Créer un conflit
    vim TODO
    git commit -a -m "Commit en conflit"
    git octopus -n features/*

    # Résoudre le conflit avec git-conflict
    git conflict TODO
    vim TODO
    git conflict --continue

    ...

