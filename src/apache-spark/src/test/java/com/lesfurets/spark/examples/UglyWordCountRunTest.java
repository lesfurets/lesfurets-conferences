package com.lesfurets.spark.examples;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UglyWordCountRunTest {

    private SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .getOrCreate();

    private Dataset<Row> text;

    @BeforeEach
    public void before() {
        Row row = RowFactory.create("this file has content, this file is love, this");

        StructField field = new StructField("line", DataTypes.StringType, false, null);
        StructType schema = new StructType(new StructField[]{field});

        text = spark.createDataFrame(singletonList(row), schema);
    }

    @Test
    public void should_file_split_return_ordered_word_count() {
        Dataset<Row> wordCount = UglyWordCountRun.countWords(text);

        assertEquals(6, wordCount.count());
        assertEquals("this", wordCount.first().<String>getAs("word"));
        assertEquals(3, (long) wordCount.first().<Long>getAs("sum(count)"));
    }

}