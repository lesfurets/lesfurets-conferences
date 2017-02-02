# Apache Spark : exemples en Java

Ce projet contient des exemples d'usage de Apache Spark en Java basés sur notre code base. Il sert de base pour notre conférence [Apache Spark : Deep dive dans l'API Java pour développeur](https://github.com/lesfurets/lesfurets-conferences#apache-spark--deep-dive-dans-lapi-java-pour-développeur) et nos articles de blog à paraitre. 

## Quelques notes en vrac

Pour activer la persistance de l'historique de vos traitements Spark pour les visualiser après l'exécution, il faut créer le dossier `mkdir /tmp/spark-events`, puis activer la propriété `spark.eventLog.enabled` :

```java
private static SparkSession spark = SparkSession.builder()
        .config("spark.eventLog.enabled", true)
        .master("local[*]")
        .getOrCreate();
```

Il faut démarrer le history server avec la commande suivante puis se rendre sur http://127.0.0.1:18080.

```bash
    ./sbin/start-history-server.sh
```

Quelques chemins :

    http://127.0.0.1:8080/
    URL: spark://127.0.1.1:7077
    REST URL: spark://127.0.1.1:6066
    WEB UI: http://127.0.0.1:4040/
    HISTORY SERVER: http://127.0.0.1:18080/

La dernière doc

    https://spark.apache.org/docs/latest/sql-programming-guide.html

Les binaires à utiliser

    ./sbin/start-master.sh
    ./sbin/start-slave.sh spark://lesfurets:7077
    ./sbin/start-history-server.sh

Pour envoyer un traitement sur le cluster

    ./bin/spark-submit --class MaClasse /le/chemin/vers/mon/jar/mon-jar.jar

Pour s'exécuter en standalone à partir de l'IDE, le cluster manager va envoyer le jar aux workers (il faut le packager avant, par exemple avec une tâche maven qui se lance de votre IDE).

```java
private static SparkSession spark = SparkSession
        .builder()
        .master("spark://127.0.1.1:7077")
        .config("spark.eventLog.enabled", true)
        .config("spark.jars", ("/path/to/jar/target/snowcamp-0.0.1.jar,"))
        .appName("LesFurets @ Snowcamp - Testing")
        .getOrCreate();
```

