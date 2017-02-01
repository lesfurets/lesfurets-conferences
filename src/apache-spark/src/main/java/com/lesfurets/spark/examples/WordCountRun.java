package com.lesfurets.spark.examples;

import com.lesfurets.spark.utils.SparkRunner;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

public class WordCountRun extends SparkRunner {

    private static SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .getOrCreate();

    public static void main(String[] args) {
        Dataset<Row> lines = spark.read()
                .text(PATH_WORDS_CSV)
                .toDF("lines");
        lines.printSchema();
        lines.show();

        countWords(lines);
    }

    public static Dataset<Row> countWords(Dataset<Row> lines) {
        Dataset<Row> words = lines
                .select(split(col("lines"), " ").alias("words"));
        words.printSchema();
        words.show();

        Dataset<Row> word = words
                .select(explode(col("words")).alias("word"));
        word.printSchema();
        word.show();

        Dataset<Row> wordCount = word
                .groupBy("word")
                .count()
                .orderBy(desc("count"));
        wordCount.printSchema();
        wordCount.show();

        return wordCount;
    }

    public static void simpleMain() {
        Dataset<Row> wordCount = spark.read()
                .text(PATH_WORDS_CSV)
                .select(split(col("lines"), " ").alias("words"))
                .select(explode(col("words")).alias("word"))
                .groupBy("word")
                .count()
                .orderBy(desc("count"));
        wordCount.printSchema();
        wordCount.show();
    }

}