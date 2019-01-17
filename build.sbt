
name := "Minokov"

version := "0.1"

scalaVersion := "2.12.6"

scalafmtConfig in ThisBuild := Some(file(".scalafmt.conf"))

// slf4j
// https://www.slf4j.org/news.html
val slf4j_api = "org.slf4j" % "slf4j-api" % "1.7.25"

// Scala Logging
// https://github.com/typesafehub/scala-logging
val scala_logging = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"

// LogBack
// https://logback.qos.ch/news.html
val logback_core = "ch.qos.logback" % "logback-core" % "1.2.3"
val logBack_classic = "ch.qos.logback" % "logback-classic" % "1.2.3"

// Dispatch
// https://github.com/dispatch/reboot
// FIXME ikeda 2016.12.13
// 2.12 対応を以下で見守る
// https://github.com/dispatch/reboot/issues/134
//val dispatch_core = "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
val dispatch_core = "net.databinder.dispatch" %% "dispatch-core" % "0.13.3"

// Typesafe Config
// https://github.com/typesafehub/config
val config = "com.typesafe" % "config" % "1.3.2"

// Jwt
// https://github.com/iain-logan/jwt
val jwt = "io.igl" %% "jwt" % "1.2.2"

// spray-json
// https://github.com/spray/spray-json
val sprayJson = "io.spray" %% "spray-json" % "1.3.3"

// redis
// https://github.com/debasishg/scala-redis
val redis_client = "net.debasishg" %% "redisclient" % "3.5"

val module_core_deps = Seq(
  slf4j_api,
  scala_logging,
  logback_core,
  logBack_classic,
  dispatch_core,
  config
)

// mockito
val mockito = "org.mockito" % "mockito-core" % "2.13.0" % "test"

// Specs2
// https://github.com/etorreborre/specs2
val specs2_core = "org.specs2" %% "specs2-core" % "4.0.4"
val specs2_mock = "org.specs2" %% "specs2-mock" % "4.0.4"
val specs2_junit = "org.specs2" %% "specs2-junit" % "4.0.4"

// scalaTest
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5" % "test"

val module_test = Seq(
  mockito,
  scalaTest
//  specs2_core % Test,
//  specs2_mock % Test,
//  specs2_junit % Test
//  specs2_core,
//  specs2_mock,
//  specs2_junit
)

libraryDependencies ++= Seq("org.apache.commons" % "commons-lang3" % "3.7", "commons-io" % "commons-io" % "2.6")
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0"
libraryDependencies += "io.gatling" % "gatling-test-framework" % "2.3.0" excludeAll (ExclusionRule(
  "com.fasterxml.jackson.core"
), ExclusionRule(
  "com.fasterxml.jackson.dataformat"
))
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.6"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.13"
libraryDependencies += "com.amazonaws" % "aws-java-sdk-kinesis" % "1.11.356" excludeAll (ExclusionRule(
  "com.fasterxml.jackson.core"
), ExclusionRule(
  "com.fasterxml.jackson.dataformat"
))
libraryDependencies += "com.amazonaws" % "aws-java-sdk-dynamodb" % "1.11.356" excludeAll (ExclusionRule(
  "com.fasterxml.jackson.core"
), ExclusionRule(
  "com.fasterxml.jackson.dataformat"
))

//--

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.9"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.9"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.9"
libraryDependencies += "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % "2.8.9"

//---

libraryDependencies ++= module_core_deps

libraryDependencies ++= module_test

//enablePlugins(CloudformationPlugin)
//enablePlugins(ServerlessPlugin)

//---
// akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.14"
//libraryDependencies += "com.typesafe.akka" %% "akka-stream-experimental_2.11" % "1.0-M3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"            % "2.5.16",
  "com.typesafe.akka" %% "akka-testkit"          % "2.5.16" % Test
)
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream"           % "2.5.16",
  "com.typesafe.akka" %% "akka-stream-testkit"   % "2.5.16" % Test
)
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"             % "10.1.5",
  "com.typesafe.akka" %% "akka-http-testkit"     % "10.1.5" % Test
)
libraryDependencies +=
  "com.typesafe.akka" %% "akka-cluster"          % "2.5.16"
libraryDependencies +=
  "com.typesafe.akka" %% "akka-cluster-sharding" %  "2.5.16"
libraryDependencies +=
  "com.typesafe.akka" %% "akka-distributed-data" % "2.5.16"
libraryDependencies +=
  "com.typesafe.akka" %% "akka-persistence"      % "2.5.16"
