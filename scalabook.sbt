ThisBuild / organization :="HMC"


val sparkVersion = "3.3.0"
val akkaVersion= "2.6.4"
val akkaHttpVersion = "10.1.11"


lazy val scalabook = project
 .in(file(","))
 .settings(
   name:="scalabook",
   scalaVersion:="2.13.11",
   libraryDependencies ++=Seq(
//akka stream
"com.typesafe.akka" %% "akka-stream" % akkaVersion,
//akka http
"com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
"com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
//spark
"org.apache.spark" %% "spark-core" % sparkVersion,
"org.apache.spark" %% "spark-sql" % sparkVersion,
"org.specs2" %% "specs2-core" % "4.11.0"% "test",
"org.specs2" %% "specs2-scalacheck" % "4.11.0" % "test",
"commons-io" % "commons-io" % "2.6",
)
)

resolvers ++=Seq(
"scalaz-bintraz" at "https://dl.bintray.com/scalaz/releases",
"sonatype Relesaes Repository" at "https://oss.sonatype/content/repositories/Releases",
)
