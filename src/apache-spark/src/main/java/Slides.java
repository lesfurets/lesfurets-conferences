import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Slides {

    private static SparkSession spark = SparkSession
            .builder()
            .master("local[*]")
            .config("spark.eventLog.enabled", true)
            .appName("LesFurets @ Snowcamp - QuestionSet")
            .getOrCreate();

    public static void main(String[] args) {
        // Lecture d'un fichier data.csv
        // avec inférence de schéma et entête
        Dataset<Row> data = spark.read()
                .option("header", true)
                .option("inferSchema", true)
                .csv("/tmp/partenaires_data.csv");

        // L'objet Row contient des colonnes typées
        data.printSchema();

        // Convertion du dataset en dataset typé Question
        Dataset<Question> domainData = data
                .as(Encoders.bean(Question.class));

        // Récupération du RDD sous-jacent au dataset
        RDD<Question> rdd = domainData.rdd();
        // API Java du RDD
        JavaRDD<Question> javaRDD = domainData.javaRDD();
    }

}
