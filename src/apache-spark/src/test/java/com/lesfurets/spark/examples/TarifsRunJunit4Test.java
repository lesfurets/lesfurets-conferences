package com.lesfurets.spark.examples;

import com.lesfurets.spark.junit4.rule.SparkTestSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.apache.spark.sql.types.DataTypes.*;
import static org.apache.spark.sql.types.Metadata.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarifsRunJunit4Test {

    @Rule
    public SparkTestSession spark = new SparkTestSession();

    private Dataset<Row> tarifs;

    @Before
    public void before() {
        List<Row> rows = Arrays.asList(
                RowFactory.create(1, 50d, "Mon SUPER assureur"),
                RowFactory.create(1, 100d, "Mon SUPER assureur"),
                RowFactory.create(2, 70d, "Mon SUPER assureur"));

        StructField formule = new StructField("formule", IntegerType, false, empty());
        StructField prime = new StructField("prime", DoubleType, false, empty());
        StructField assureur = new StructField("assureur", StringType, false, empty());
        StructType structType = new StructType(new StructField[]{formule, prime, assureur});

        tarifs = spark.getSpark().createDataFrame(rows, structType);
    }

    @Test
    public void should_average_tarif_return_correct_average() {
        Dataset<Row> averagePrime = TarifsRun.averagePrime(tarifs);

        assertEquals(2, averagePrime.count());
        assertEquals(1, (int) averagePrime.first().<Integer>getAs("formule"));
        assertEquals("tiers bdg", averagePrime.first().getAs("formuleReadable"));
        assertEquals(75, averagePrime.first().<Double>getAs("average"), 0.001);
    }

}
