package com.lesfurets.spark.examples;

import com.lesfurets.spark.utils.SparkRunner;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.types.DataTypes;

import static org.apache.spark.sql.functions.*;

public class WhozTarifRun extends SparkRunner {

    private final static SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .getOrCreate();

    public static void main(String[] args) {
        Dataset<Row> tarifs = spark.read()
                .option("header", true)
                .option("inferSchema", true)
                .csv(PATH_TARIFS_CSV);
        tarifs.printSchema();
        tarifs.show();

        averagePrime(tarifs);
    }

    static Dataset<Row> averagePrime(Dataset<Row> tarifs) {
        Dataset<Row> primeAverage = tarifs
                .filter((FilterFunction<Row>) row ->
                        row.<String>getAs("assureur").equals("Mon SUPER assureur"))
                .groupBy("formule")
                .agg(avg("prime").as("average"));
        primeAverage.printSchema();
        primeAverage.show();

        spark.udf().register("readableFormule",
                (UDF1<String, String>) String::toLowerCase,
                DataTypes.StringType);

        Dataset<Row> orderedAverage = primeAverage
                .withColumn("readableFormule", callUDF("readableFormule", col("formule")))
                .orderBy(desc("average"));
        orderedAverage.printSchema();
        orderedAverage.show();

        return orderedAverage;
    }

}
