import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.HashMap;
import java.util.Map;

public class Cassandra {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .master("local[*]")
                .config("spark.eventLog.enabled", true)
                .appName("LesFurets @ Snowcamp - Cassandra")
                .getOrCreate();

        Map<String, String> tableQuestionSetByDate = new HashMap<>();
        tableQuestionSetByDate.put("table", "question_set_by_date");
        tableQuestionSetByDate.put("keyspace", "prod");

        DataFrameReader questionSetByDateReader = spark.sqlContext().read()
                .format("org.apache.spark.sql.cassandra")
                .options(tableQuestionSetByDate);

        Dataset<Row> load = questionSetByDateReader.load();
        load.printSchema();
    }

}
