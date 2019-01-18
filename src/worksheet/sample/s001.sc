//case class Person(id: String)
//
//val maybe = for {
//  p <- "hoge"
//  t <- "1"
//} yield (p, t, Person(id = "a"))
//
//maybe

//---

//val p: (Int, Int, Int) = (30, 40, 50)
//p match {
//  case (x, y, z) =>
//    println(x)
//    println(y)
//    println(z)
//}

//---

import java.util.Date

lazy val a: Date = new Date
val b: Date = new Date

Thread.sleep(3000)

println("%tY-%<tm-%<td %<tH:%<tM:%<tS %<tZ %<tz" format new Date)
println("%tY-%<tm-%<td %<tH:%<tM:%<tS %<tZ %<tz" format a)
println("%tY-%<tm-%<td %<tH:%<tM:%<tS %<tZ %<tz" format b)

