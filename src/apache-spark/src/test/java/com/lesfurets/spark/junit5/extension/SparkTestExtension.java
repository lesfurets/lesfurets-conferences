package com.lesfurets.spark.junit5.extension;

import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import static java.lang.reflect.Modifier.isPublic;
import static java.util.Arrays.stream;

class SparkTestExtension implements TestInstancePostProcessor, ParameterResolver {

    private static final String MASTER = "local[*]";

    private static SparkSession spark;

    private static synchronized SparkSession getSparkOrInitialize() {
        if (spark == null) {
            System.out.println("Starting SparkSession " + MASTER);
            spark = SparkSession.builder()
                    .config("spark.ui.enabled", false)
                    .master(MASTER)
                    .getOrCreate();
        }
        return spark;
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        stream(testInstance.getClass().getDeclaredFields())
                .filter(field -> field.getType() == SparkSession.class)
                .filter(field -> isPublic(field.getModifiers()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Need one public SparkSession field"))
                .set(testInstance, getSparkOrInitialize());
    }

    @Override
    public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType().equals(SparkSession.class);
    }

    @Override
    public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return getSparkOrInitialize();
    }

}