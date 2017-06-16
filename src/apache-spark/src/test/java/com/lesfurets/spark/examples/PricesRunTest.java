package com.lesfurets.spark.examples;

import static org.apache.spark.api.java.JavaSparkContext.fromSparkContext;
import static org.apache.spark.sql.types.DataTypes.DoubleType;
import static org.apache.spark.sql.types.DataTypes.IntegerType;
import static org.apache.spark.sql.types.DataTypes.StringType;
import static org.apache.spark.sql.types.Metadata.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.*;

import org.apache.spark.api.java.function.ForeachFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.*;

import com.lesfurets.spark.junit5.extension.SparkTest;

@SparkTest
public class PricesRunTest {

    public SparkSession spark;

    private Dataset<Row> tarifs;

    @BeforeEach
    public void before() {
        List<Row> rows = Arrays.asList(
                RowFactory.create(1, 50d, "COOL insurer"),
                RowFactory.create(1, 100d, "COOL insurer"),
                RowFactory.create(2, 70d, "COOL insurer"));

        StructField product = new StructField("product", IntegerType, false, empty());
        StructField price = new StructField("price", DoubleType, false, empty());
        StructField insurer = new StructField("insurer", StringType, false, empty());
        StructType structType = new StructType(new StructField[]{product, price, insurer});

        tarifs = spark.createDataFrame(rows, structType);
    }

    @Test
    public void should_average_price_return_correct_average() {
        Dataset<Row> averagePrice = PricesRun.averagePrice(tarifs);

        averagePrice.foreach((ForeachFunction<Row>) row -> assertNotNull(row.getAs("readableProduct")));

        Broadcast<List<String>> broadcast = fromSparkContext(spark.sparkContext()).broadcast(new ArrayList<>());
        averagePrice.foreach((ForeachFunction<Row>) row -> broadcast.value().add(row.getAs("readableProduct")));
        broadcast.value().forEach(Assertions::assertNotNull);

        assertEquals(2, averagePrice.count());
        assertEquals(1, (int) averagePrice.first().<Integer>getAs("product"));
        assertEquals("third party plus", averagePrice.first().getAs("readableProduct"));
        assertEquals(75, averagePrice.first().<Double>getAs("average"), 0.001);
    }

}
