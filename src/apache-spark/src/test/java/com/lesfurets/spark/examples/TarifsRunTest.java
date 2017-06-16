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
public class TarifsRunTest {

    public SparkSession spark;

    private Dataset<Row> tarifs;

    @BeforeEach
    public void before() {
        List<Row> rows = Arrays.asList(
                        RowFactory.create(1, 50d, "Mon SUPER assureur"),
                        RowFactory.create(1, 100d, "Mon SUPER assureur"),
                        RowFactory.create(2, 70d, "Mon SUPER assureur"));

        StructField formule = new StructField("formule", IntegerType, false, empty());
        StructField prime = new StructField("prime", DoubleType, false, empty());
        StructField assureur = new StructField("assureur", StringType, false, empty());
        StructType structType = new StructType(new StructField[] { formule, prime, assureur });

        tarifs = spark.createDataFrame(rows, structType);
    }

    @Test
    public void should_average_tarif_return_correct_average() {
        Dataset<Row> averagePrime = TarifsRun.averagePrime(tarifs);

        averagePrime.foreach((ForeachFunction<Row>) row -> assertNotNull(row.getAs("formuleReadable")));

        Broadcast<List<String>> broadcast = fromSparkContext(spark.sparkContext()).broadcast(new ArrayList<>());
        averagePrime.foreach((ForeachFunction<Row>) row -> broadcast.value().add(row.getAs("formuleReadable")));
        broadcast.value().forEach(Assertions::assertNotNull);

        assertEquals(2, averagePrime.count());
        assertEquals(1, (int) averagePrime.first().<Integer> getAs("formule"));
        assertEquals("tiers bdg", averagePrime.first().getAs("formuleReadable"));
        assertEquals(75, averagePrime.first().<Double> getAs("average"), 0.001);
    }

}
