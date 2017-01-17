package com.lesfurets.spark.examples;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.apache.spark.sql.types.DataTypes.DoubleType;
import static org.apache.spark.sql.types.DataTypes.StringType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarifsRunTest {

    private static final SparkSession spark = SparkSession.builder()
            .appName("TestableStatistiquesPartenaireTest")
            .master("local[*]")
            .getOrCreate();

    private Dataset<Row> tarifs;

    @BeforeEach
    public void before() {
        List<Row> rows = Arrays.asList(RowFactory.create("FORMULE 1", 50d, "Mon SUPER assureur"),
                RowFactory.create("FORMULE 1", 100d, "Mon SUPER assureur"),
                RowFactory.create("FORMULE 2", 70d, "Mon SUPER assureur"));

        StructField formule = new StructField("formule", StringType, false, Metadata.empty());
        StructField prime = new StructField("prime", DoubleType, false, Metadata.empty());
        StructField assureur = new StructField("assureur", StringType, false, Metadata.empty());
        StructType structType = new StructType(new StructField[]{formule, prime, assureur});

        tarifs = spark.createDataFrame(rows, structType);
    }

    @Test
    public void should_average_tarif_return_correct_average() {
        Dataset<Row> averagePrime = TarifsRun.averagePrime(tarifs);

        assertEquals(2, averagePrime.count());
        assertEquals("FORMULE 1", averagePrime.first().getAs("formule"));
        assertEquals("formule 1", averagePrime.first().getAs("formuleReadable"));
        assertEquals(75, (double) averagePrime.first().<Double>getAs("average"));
    }

}