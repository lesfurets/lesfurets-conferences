package com.lesfurets.spark.data;

import com.lesfurets.spark.utils.SparkRunner;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.format_string;

public class SampleTarifsRun extends SparkRunner {

    private static final String PATH = "/tmp/tarifs.csv";

    private static final SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .getOrCreate();

    public static void main(String[] args) {
        Dataset<Row> tarifs = spark.read()
                .option("header", true)
                .option("inferSchema", true)
                .csv(PATH)
                .toDF();
        tarifs.printSchema();
        System.out.println(tarifs.count());

        Dataset<Row>[] tarifsSmalls = tarifs
                .select("uid", "date", "heure", "module", "formule", "prime")
                .withColumn("provider", format_string("Mon SUPER assureur"))
                .randomSplit(new double[]{Math.random(), Math.random()});

        System.out.println(tarifsSmalls.length);
        System.out.println(tarifsSmalls[0].count());
        System.out.println(tarifsSmalls[1].count());

        tarifsSmalls[0].show();
        tarifsSmalls[1].show();

        Dataset<Row> tarifsSmall = tarifsSmalls[0];
        tarifsSmall.write()
                .mode(SaveMode.Append)
                .csv("/tmp/tarifs_small.csv");
    }

}
