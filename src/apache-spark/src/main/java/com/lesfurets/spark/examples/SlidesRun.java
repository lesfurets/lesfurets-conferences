package com.lesfurets.spark.examples;

import com.lesfurets.bean.Question;
import com.lesfurets.spark.utils.SparkRunner;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SlidesRun extends SparkRunner {

    private static SparkSession spark = SparkSession.builder()
            .config("spark.eventLog.enabled", true)
            .master("local[*]")
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
