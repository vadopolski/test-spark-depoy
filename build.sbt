name := "test-spark-depoy"
version := "0.1"
scalaVersion := "2.12.7"

val sparkVersion = "3.0.2"


libraryDependencies ++= Seq(
//  "org.apache.commons" %% "commons-lang3" % "3.12.0",
  "com.github.scopt" %% "scopt" % "4.0.1",
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
)

Compile / mainClass  := Some("SimpleApp")
assembly / mainClass := Some("SimpleApp")

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
