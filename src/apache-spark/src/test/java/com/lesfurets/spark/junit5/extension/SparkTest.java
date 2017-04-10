package com.lesfurets.spark.junit5.extension;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Add annotation on Spark test class with public field of type SparkSession, or on Spark test method with parameter
 * of type SparkSession, to get injected SparkSession. The SparkSession is automatically initialized at the beginning
 * of tests with mode local[*] and is shared between test instances.
 *
 * <b>Usage on class:</b>
 *
 * <pre><code>
 * {@literal @}SparkTest
 * public class SparkTest {
 *     // The field "spark" will be injected
 *     public SparkSession spark;
 * }</code></pre>
 *
 * <b>Usage on method:</b>
 *
 * <pre><code>
 * public class SparkTest {
 *    {@literal @}Test
 *     // The parameter "spark" will be injected
 *     public void test(SparkSession spark) { }
 * }</code></pre>
 */
@Target({TYPE, METHOD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(SparkTestExtension.class)
public @interface SparkTest {

}
