// https://dwango.github.io/scala_text/control-syntax.html
for (x <- 1 to 5; y <- 1 until 5) {
  println("x = " + x + " y = " + y)
}

//

for (x <- 1 to 5; y <- 1 until 5 if x != y) {
  println("x = " + x + " y = " + y)
}

//

for (e <- List("A", "B", "C", "D", "E")) println(e)

//

for (e <- List("A", "B", "C", "D", "E")) yield {
  "Pre" + e
}

//

val lst = List("A", "B", "C", "D", "E")
lst match {
  case List("A", b, c, d, e) =>
    println("b = " + b)
    println("c = " + c)
    println("d = " + d)
    println("e = " + e)
  case _                     =>
    println("nothing")
}
