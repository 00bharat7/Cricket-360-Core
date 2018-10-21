name := "Cricket360"
 
version := "1.0" 
      
lazy val `cricket360` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice, mongo_casbah, lift_json, joda )

val mongo_casbah = "org.mongodb" %% "casbah" % "3.1.1"

val lift_json = "net.liftweb" %% "lift-json" % "3.0.1"

val joda = "joda-time" % "joda-time" % "2.10"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      