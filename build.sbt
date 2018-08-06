name := "Minokov"

version := "0.1"

scalaVersion := "2.12.5"

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

// Specs2
// https://github.com/etorreborre/specs2
val specs2_core = "org.specs2" %% "specs2-core" % "4.0.4"
val specs2_mock = "org.specs2" %% "specs2-mock" % "4.0.4"
val specs2_junit = "org.specs2" %% "specs2-junit" % "4.0.4"

// akka
val akka_actor = "com.typesafe.akka" %% "akka-actor" % "2.5.14"

val module_core_deps = Seq(
  slf4j_api,
  scala_logging,
  logback_core,
  logBack_classic,
  dispatch_core,
  config,
  specs2_core % Test,
  specs2_mock % Test,
  specs2_junit % Test,
  akka_actor
)

libraryDependencies ++= Seq("org.apache.commons" % "commons-lang3" % "3.7",
  "commons-io" % "commons-io" % "2.6")
libraryDependencies ++= module_core_deps

//enablePlugins(CloudformationPlugin)
//enablePlugins(ServerlessPlugin)
