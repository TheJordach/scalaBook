ThisBuild / organization :="HMC"

lazy val scalabook = project
 .in(file(","))
 .settings(
   name:="scalabook",
   scalaVersion:="2.13.11",
   libraryDependencies ++=Seq(
"org.specs2" %% "specs2-core" % "4.11.0"% "test",
"org.specs2" %% "specs2-scalacheck" % "4.11.0" % "test",
)
)

resolvers ++=Seq(
"scalaz-bintraz" at "https://dl.bintray.com/scalaz/releases",
"sonatype Relesaes Repository" at "https://oss.sonatype/content/repositories/Releases",
)
