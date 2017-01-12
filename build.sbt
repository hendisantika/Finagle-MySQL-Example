name := "MySQlTest"

version := "1.0"

scalaVersion := "2.12.1"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.twitter" %% "finagle-http" % "6.41.0",
  "com.twitter" %% "finagle-mysql" % "6.41.0",
  "mysql" % "mysql-connector-java" % "5.1.40"
).map(_.exclude("com.google.code.findbugs", "jsr305"))

//mainClass in (Compile, run) := Some("com.hendisantika.Sandbox.Main")
//mainClass in (Compile, run) := Some("Main")

    