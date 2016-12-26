import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import static java.util.Arrays.asList;
import static org.apache.spark.sql.Encoders.*;
import static org.apache.spark.sql.functions.desc;

public class Count {

    private static final String PATH = "src/main/resources/words.txt";

    private static SparkSession spark = SparkSession
            .builder()
            .master("local[*]")
            .config("spark.eventLog.enabled", true)
            .appName("LesFurets @ Snowcamp - Count")
            .getOrCreate();

    static {
        Logger.getRootLogger().setLevel(Level.WARN);
        Logger.getLogger("org").setLevel(Level.WARN);
        spark.sparkContext().setLogLevel("WARN");
    }

    public static void main(String[] args) {
        Dataset<Row> lines = spark.read().text(PATH).toDF("line");
        System.out.println("LINES : " + lines.count());

        Dataset<Row> wordCount = countWords(lines);
        System.out.println("WORDS : " + wordCount.count());
    }

    public static Dataset<Row> countWords(Dataset<Row> lines) {
        Dataset<Row> wordCount = lines
                .flatMap((FlatMapFunction<Row, String>) row ->
                        asList(row.<String>getAs("line").split(" ")).iterator(), STRING())
                .map((MapFunction<String, Tuple2<String, Integer>>) word ->
                        new Tuple2<>(word, 1), tuple(STRING(), INT()))
                .toDF("word", "count");

        wordCount.show();

        Dataset<Row> wordCountSum = wordCount
                .groupBy("word")
                .sum("count")
                .orderBy(desc("sum(count)"))
                .toDF();
        wordCountSum.show();

        return wordCountSum;
    }

    public static <A, B> FlatMapFunction<A, B> captureFlatMap(FlatMapFunction<A, B> function) {
        return function;
    }

    public static <A, B> MapFunction<A, B> captureMap(MapFunction<A, B> function) {
        return function;
    }

}