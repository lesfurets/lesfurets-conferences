package com.lesfurets.spark.examples;

import com.lesfurets.spark.utils.SparkRunner;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import static java.util.Arrays.asList;
import static org.apache.spark.sql.Encoders.*;
import static org.apache.spark.sql.functions.desc;

public class UglyWordCountRun extends SparkRunner {

    private static SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .getOrCreate();

    public static void main(String[] args) {
        Dataset<Row> lines = spark.read().text(PATH_WORDS_CSV).toDF("line");
        System.out.println("LINES : " + lines.count());

        Dataset<Row> wordCount = countWords(lines);
        System.out.println("WORDS : " + wordCount.count());
    }

    public static Dataset<Row> countWords(Dataset<Row> lines) {
        Dataset<Row> wordCount = lines
                .flatMap((FlatMapFunction<Row, String>) row ->
                        asList(row.<String>getAs("line").split(" ")).iterator(), STRING())
                .map((MapFunction<String, Tuple2<String, Integer>>) word ->
                        new Tuple2<>(word, 1), tuple(STRING(), INT()))
                .toDF("word", "count");

        wordCount.show();

        Dataset<Row> wordCountSum = wordCount
                .groupBy("word")
                .sum("count")
                .orderBy(desc("sum(count)"))
                .toDF();
        wordCountSum.show();

        return wordCountSum;
    }

    public static Dataset<Row> all(Dataset<Row> lines) {
        Dataset<Row> wordCount = lines
                .flatMap((FlatMapFunction<Row, String>) row -> {
                    String[] words = row.<String>getAs("line").split(" ");
                    return asList(words).iterator();
                }, STRING())
                .map((MapFunction<String, Tuple2<String, Integer>>) word ->
                        new Tuple2<>(word, 1), tuple(STRING(), INT()))
                .toDF("word", "count")
                .groupBy("word")
                .sum("count")
                .orderBy(desc("sum(count)"))
                .toDF();
        wordCount.show();
        return wordCount;
    }

}