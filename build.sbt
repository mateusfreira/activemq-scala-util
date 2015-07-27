resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers +=  "maven" at "http://repo1.maven.org/maven2/"

resolvers += "apache" at "https://repository.apache.org/content/repositories/snapshots/"

resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/snapshots/"


libraryDependencies ++= Seq(
   "javax.jms" % "jms" % "1.1" % "compile" from "http://www.datanucleus.org/downloads/maven2/javax/jms/jms/1.1/jms-1.1.jar",
   "org.apache.activemq" % "activemq-core" % "5.5.1"  % "compile",
   "org.specs2" %% "specs2" % "1.12.3" % "test",
   	"org.slf4j" % "slf4j-log4j12" %	"1.5.6"
)

parallelExecution in Test := false

name := "activemq-scala-util"

organization := "activemq"

version := "0.1-SNAPSHOT"

publishTo := Some("Sonatype Snapshots Nexus" at "https://oss.sonatype.org/content/repositories/snapshots")