package com.lesfurets.spark.data;

import com.lesfurets.bean.Question;
import com.lesfurets.spark.utils.SparkRunner;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

public class QuestionSetRun extends SparkRunner {

    private static SparkSession spark = SparkSession
            .builder()
            .master("local[*]")
            .getOrCreate();

    public static void main(String[] args) {
        Dataset<Row> data = spark.read().csv("data.csv");
        Dataset<Question> domainData = data.as(Encoders.bean(Question.class));

        Dataset<Row> df = spark.read()
                .option("header", true)
                .option("inferSchema", true)
                .option("delimiter", ";")
                .csv("/tmp/question_set_auto_2015.csv");
        df.printSchema();

        System.out.println(df.count());
        System.out.println(df.filter(col("COORD_COMMUNE_VALUE").endsWith("CON")).count());

        Dataset<Question> ds = df
                .withColumnRenamed("ASS_DTL_FORM_CHOIX", "couverture")
                .withColumnRenamed("COORD_COMMUNE_VALUE", "commune")
                .as(Encoders.bean(Question.class));

        ds.show();
    }

}
