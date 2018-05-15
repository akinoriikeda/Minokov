val lt = List(1, 2, 3, 4, 5)

lt.map(_ + 1)
lt.fold(0)(_ + _)

//Option
val maybeMoney1: Option[Int] = Some(1000)
val message1 = maybeMoney1.fold("お金もってないよ！") { money =>
  s"お金${money}円あるよ！"
}
val maybeMoney2: Option[Int] = None
val message2 = maybeMoney2.fold("お金もってないよ！") { money =>
  s"お金${money}円あるよ！"
}
