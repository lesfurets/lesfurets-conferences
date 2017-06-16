package com.lesfurets.spark.examples;

import com.lesfurets.domain.ProductMapper;
import com.lesfurets.spark.utils.SparkRunner;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;

import static org.apache.spark.sql.functions.*;
import static org.apache.spark.sql.types.DataTypes.StringType;

public class TarifsRun extends SparkRunner {

    private static final SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .getOrCreate();

    static {
        spark.udf().register("readableFormule", (UDF1<Integer, String>) ProductMapper::french, StringType);
    }

    public static void main(String[] args) {
        Dataset<Row> tarifs = spark.read()
                .option("header", true)
                .option("inferSchema", true)
                .csv(PATH_TARIFS_CSV);
        tarifs.printSchema();
        tarifs.show();

        averagePrime(tarifs);
    }

    public static Dataset<Row> averagePrime(Dataset<Row> tarifs) {
        Dataset<Row> averagePrime = tarifs
                .filter((FilterFunction<Row>) value ->
                        value.<String>getAs("assureur").equals("Mon SUPER assureur"))
                .groupBy("formule")
                .agg(avg("prime").as("average"))
                .withColumn("formuleReadable", callUDF("readableFormule", col("formule")))
                .orderBy(desc("average"));
        averagePrime.show();

        return averagePrime;
    }

}
