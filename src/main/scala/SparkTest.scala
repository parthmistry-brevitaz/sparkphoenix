
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql._
import org.apache.phoenix.spark._

import scala.collection.mutable.ArrayBuffer

/**
  * Created by parthmistry on 20/11/16.
  */
object SparkTest {

  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("SparkTest")
    val sc = new SparkContext(sparkConf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    val df = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("hdfs:///user/spark/users.csv")
    df.write.format("com.databricks.spark.csv").save("hdfs:///user/spark/output.csv");

  }

}
