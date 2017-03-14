package com.lesfurets.spark.junit4.rule;

import org.apache.spark.sql.SparkSession;
import org.junit.rules.ExternalResource;

/**
 * Use as JUnit {@code @Rule} in test class to get shared SparkSession. The SparkSession is automatically initialized at
 * the beginning of tests with mode local[*] and is shared between test instances.
 */
public class SparkTestSession extends ExternalResource {

    private static final String MASTER = "local[*]";

    private static SparkSession spark;

    private static synchronized void initSparkIfNecessary() {
        if (spark == null) {
            System.out.println("Starting SparkSession " + MASTER);
            spark = SparkSession.builder()
                    .config("spark.ui.enabled", false)
                    .master(MASTER)
                    .getOrCreate();
        }
    }

    @Override
    protected void before() throws Throwable {
        initSparkIfNecessary();
    }

    public SparkSession getSpark() {
        return spark;
    }

}