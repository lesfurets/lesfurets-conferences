package com.lesfurets.spark.examples;

import com.lesfurets.spark.utils.SparkRunner;
import org.apache.spark.sql.*;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.storage.StorageLevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static org.apache.spark.sql.functions.avg;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.substring;
import static org.apache.spark.sql.types.DataTypes.StringType;

public class QuestionSetRun extends SparkRunner {

    private static final SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .getOrCreate();

    static {
        Map<Integer, String> collect = spark.read()
                .option("delimiter", ";")
                .csv("/home/alexandre/Downloads/codepostal_libelle.csv")
                .collectAsList()
                .stream()
                .collect(toMap(row -> Integer.parseInt(row.getString(0)), row -> row.getString(1), (s1, s2) -> s1));
        spark.udf().register("zipName", (UDF1<Integer, String>) collect::get, StringType);
    }

    public static void main(String[] args) throws IOException {
        Dataset<Row> questionSet = spark.read()
                .option("header", true)
                .option("inferSchema", true)
                .option("delimiter", ";")
                .option("mode", "DROPMALFORMED")
                .csv("/home/alexandre/Documents/project/kaggle/datasets/auto/question_set_auto_2015.csv");
        questionSet.printSchema();
        questionSet.show();

        spark.sqlContext().registerDataFrameAsTable(questionSet, "questionSet");
        spark.sql("SELECT DISTINCT traffic_source FROM questionSet").show();
        spark.sql("SELECT traffic_source, count(*) FROM questionSet GROUP BY traffic_source").show();

        questionSet.persist(StorageLevel.MEMORY_AND_DISK());

        Path tempDirectory = Files.createTempDirectory(null);
        questionSet.sample(false, 0.01)
                .write()
                .mode(SaveMode.Append)
                .csv(tempDirectory.toString());

        Dataset<Row> worstNoClaimBonus = questionSet
                .select(col("OFFRE_UID").as("id"),
                        col("COORD_CODEPOSTAL_VALUE").as("zip"),
                        col("PRI_HIS_BONUS_TAUX").as("noClaimBonus"))
                .groupBy(substring(col("zip"), 0, 2).as("departement"))
                .agg(avg("noClaimBonus").as("averageNoClaimBonus"))
                .orderBy(col("averageNoClaimBonus").desc());
//        worstNoClaimBonus.show();
    }

}
