TODO

- Check how to start 2 executors

Enable persistent event log to see execution after the fact
 
    spark.eventLog.enabled=true
    mkdir /tmp/spark-events

Default paths

    http://127.0.0.1:8080/
    URL: spark://127.0.1.1:7077
    REST URL: spark://127.0.1.1:6066
    WEB UI: http://127.0.0.1:4040/
    HISTORY SERVER: http://127.0.0.1:18080/

Doc

    https://spark.apache.org/docs/latest/sql-programming-guide.html

Bins

    ./sbin/start-master.sh
    ./sbin/start-slave.sh spark://lesfurets:7077
    ./sbin/start-history-server.sh
 
Versions
 
    2.1.8 cassandra version (deb)
    ??? spark (deb)
    ??? spark cassandra connector (github clone tag 2.0.0 and sbt install)

Spark submit

    ./bin/spark-submit --class Count /home/alexandre/Documents/project/snowcamp/target/snowcamp-0.0.1.jar

Send on wire (NOT necessary if you use the local[*] syntax)

    private static SparkSession spark = SparkSession
            .builder()
            .master("spark://127.0.1.1:7077")
            .config("spark.eventLog.enabled", true)
            .config("spark.jars", ("/path/to/jar/target/snowcamp-0.0.1.jar,"))
            .appName("LesFurets @ Snowcamp - Testing")
            .getOrCreate();
