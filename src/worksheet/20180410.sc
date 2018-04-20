// scala cup book third p309 -

val words = List("the", "quick", "brown", "fox")

words.map(_.length)
words.filter(_.length == 3)

words.map(_.toList)
words.flatMap(_.toList)

val r1 = List.range(1, 5)
r1.flatMap (i =>
  List.range(1, i).map(j =>
    (i, j)
  )
)

for {
  i <- List.range(1, 5)
  j <- List.range(1, i)
} yield {
  (i, j)
}

val l = List(1, 2, 3, 4, 5)
l.filter(_ % 2 == 0)
l.partition(_ % 2 == 0)
l.find(_ % 2 == 0)
l.find(_ % 7 == 0)

val ll = List(1, 3)
ll.filter(_ % 2 == 0)

(" " /: words) (_ + " " + _)
(words.head /: words.tail) (_ + " " + _)
words.head
words.tail





