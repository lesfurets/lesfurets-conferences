package com.lesfurets.spark.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class SparkRunner {

    public static final String PATH_TARIFS_CSV = "src/main/resources/tarifs.csv";

    public static final String PATH_PRICES_CSV = "src/main/resources/prices.csv";

    public static final String PATH_WORDS_CSV = "src/main/resources/words.csv";

    static {
        Logger.getRootLogger().setLevel(Level.WARN);
        Logger.getLogger("org").setLevel(Level.WARN);
        Logger.getLogger("akka").setLevel(Level.WARN);
    }

}
