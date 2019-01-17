case class Person(id: String)

val maybe = for {
  p <- "hoge"
  t <- "1"
} yield (p, t, Person(id = "a"))

maybe
