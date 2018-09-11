import scala.collection.immutable.ListMap

val params = ListMap(
  "awsRegion" -> "us-east-1",
  "envName" -> "dev")

val message = params map { case (key, value) => s"$key: $value" } mkString ("Following parameters are loaded. ", ", ", ".")
println(message)
