import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.sum;

public class StatistiquesPartenaire {

    private static SparkSession spark = SparkSession
            .builder()
            .master("local[*]")
            .config("spark.eventLog.enabled", true)
            .appName("LesFurets @ Snowcamp - StatistiquesPartenaire")
            .getOrCreate();


    public static void main(String[] args) {
        Dataset<Row> df = spark.read()
                .option("header", true)
                .option("inferSchema", true)
                .csv("/tmp/partenaires_data.csv");
        df.printSchema();

        Dataset<Row> agg = df
                .filter(col("prime").gt(1000))
                .groupBy(col("type_formule"))
                .agg(sum("devis_ok"),
                        sum("rappel_ok"),
                        sum("souscription_ok"));

        agg.explain(true);
        agg.show();
        // Scala only...
        // org.apache.spark.sql.execution.debug.debugCodegen
    }

}
