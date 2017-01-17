package com.lesfurets.spark.utils;

import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.MapFunction;

public class Sparks {

    public static <A, B> FlatMapFunction<A, B> captureFlatMap(FlatMapFunction<A, B> function) {
        return function;
    }

    public static <A, B> MapFunction<A, B> captureMap(MapFunction<A, B> function) {
        return function;
    }

}
