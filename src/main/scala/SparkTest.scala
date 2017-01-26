
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
    df.save("org.apache.phoenix.spark", SaveMode.Overwrite, Map("table" -> "users",
      "zkUrl" -> "10.103.36.96:2181:/hbase"))


  }

}
