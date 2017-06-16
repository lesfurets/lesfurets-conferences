package com.lesfurets.spark.examples;

import com.lesfurets.domain.ProductMapper;
import com.lesfurets.spark.utils.SparkRunner;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.api.java.UDF1;

import static org.apache.spark.sql.functions.*;
import static org.apache.spark.sql.types.DataTypes.StringType;

public class PricesRun extends SparkRunner {

    private static final SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .getOrCreate();

    static {
        spark.udf().register("readableProduct", (UDF1<Integer, String>) ProductMapper::english, StringType);
    }

    public static void main(String[] args) {
        Dataset<Row> prices = spark.read()
                .option("header", true)
                .option("inferSchema", true)
                .csv(PATH_PRICES_CSV);
        prices.printSchema();
        prices.show();

        averagePrice(prices);
    }

    public static Dataset<Row> averagePrice(Dataset<Row> prices) {
        Dataset<Row> averagePrice = prices
                .filter((FilterFunction<Row>) value ->
                        value.<String>getAs("insurer").equals("COOL insurer"))
                .groupBy("product")
                .agg(avg("price").as("average"))
                .withColumn("readableProduct", functions.callUDF("readableProduct", col("product")))
                .orderBy(desc("average"));
        averagePrice.show();
        return averagePrice;
    }

}
