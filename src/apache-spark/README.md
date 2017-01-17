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

Spark submit

    ./bin/spark-submit --class Count /home/alexandre/Documents/project/snowcamp/target/snowcamp-0.0.1.jar

Standalone mode (NOT necessary if you use the local[*] syntax)

    private static SparkSession spark = SparkSession
            .builder()
            .master("spark://127.0.1.1:7077")
            .config("spark.eventLog.enabled", true)
            .config("spark.jars", ("/path/to/jar/target/snowcamp-0.0.1.jar,"))
            .appName("LesFurets @ Snowcamp - Testing")
            .getOrCreate();
