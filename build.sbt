name := "sparkphoenix"

version := "1.0"

scalaVersion := "2.10.5"

resolvers += "Cloudera" at "https://repository.cloudera.com/content/repositories/releases/"
resolvers += "Spring Plugins" at "http://repo.spring.io/plugins-release/"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.10" % "1.6.0" % "provided",
  "org.apache.spark" % "spark-sql_2.10" % "1.6.0" % "provided",
  "org.apache.hbase" % "hbase-common" % "1.2.0-cdh5.9.1",
  "org.apache.hbase" % "hbase-client" % "1.2.0-cdh5.9.1",
  "org.apache.hbase" % "hbase-server" % "1.2.0-cdh5.9.1",
  "org.apache.phoenix" % "phoenix-core" % "4.9.0-HBase-1.2",
  "org.apache.phoenix" % "phoenix-spark" % "4.9.0-HBase-1.2",
  "com.databricks" % "spark-csv_2.10" % "1.5.0"
)

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
}

