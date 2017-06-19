import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.functions;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.desc;
import static org.apache.spark.sql.types.DataTypes.StringType;


public class Step1 {
    static{
        Logger.getRootLogger().setLevel(Level.ERROR);
        Logger.getLogger("org").setLevel(Level.WARN);
        Logger.getLogger("akka").setLevel(Level.WARN);
    }
    private static final SparkSession spark = SparkSession.builder()
            .appName("Step1")
            .master("local[*]")
            .getOrCreate();

    public static void main(String[] args) {


        Dataset<Row> tarifs = spark.read()
                .option("header", true)
                .option("inferSchema",true)
                .csv(Constants.PATH_TARIFS_CSV);
        tarifs
                .show(3);
        System.out.println(tarifs.schema());//bizarre le toString

        Dataset<Row> averagePrice = tarifs.filter("assureur = 'Mon SUPER assureur'")
                .groupBy("formule")
                .mean("prime")
                .orderBy(desc("avg(prime)"));

        averagePrice.show(10);

        spark.udf().register("readableFormule",
                (UDF1<Integer, String>) FormuleMapper::asString, StringType);

        averagePrice.withColumn("readableFormule",callUDF("readableFormule", functions.col("formule"))).show(3);


    }
}
