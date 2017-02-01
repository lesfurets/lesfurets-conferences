package com.lesfurets.spark.examples;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WhozTarifRunTest {

    private final static SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .appName("Whoz")
            .getOrCreate();
    private Dataset<Row> tarifs;

    @BeforeEach
    public void before() {
        List<Row> rows = Arrays.asList(
                RowFactory.create("F1", 80d, "Mon SUPER assureur"),
                RowFactory.create("F1", 100d, "Mon SUPER assureur"),
                RowFactory.create("F2", 80d, "Mon SUPER assureur"));

        StructField formule = new StructField("formule", DataTypes.StringType, false, Metadata.empty());
        StructField prime = new StructField("prime", DataTypes.DoubleType, false, Metadata.empty());
        StructField assureur = new StructField("assureur", DataTypes.StringType, false, Metadata.empty());

        tarifs = spark.createDataFrame(rows, new StructType(new StructField[]{formule, prime, assureur}));
    }

    @Test
    public void should_average_prime_return_ordered_average() {
        Dataset<Row> averagePrime = WhozTarifRun.averagePrime(tarifs);

        assertEquals("F1", averagePrime.first().<String>getAs("formule"));
        assertEquals(90d, (double) averagePrime.first().<Double>getAs("average"));
        assertEquals("f1", averagePrime.first().<String>getAs("readableFormule"));
    }

}