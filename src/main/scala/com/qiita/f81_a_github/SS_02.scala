package com.qiita.f81_a_github

//https://qiita.com/f81@github/items/9f0b9cc5c0f28deb48e2

object FunctionExample {

  def main(args: Array[String]) = {
    val calculate = (x: Int) => x + 5: Int

    printf("y = %s \n", calculate(1))
    printf("y = %s \n", calculate(2))
  }
}

object Mutable {
  def main(args: Array[String]) = {
    var mutable = "Mutable"
    println(s"$mutable")

    mutable = "Change mutable"
    println(s"$mutable")
  }
}

object Immutable {
  def main(args: Array[String]) = {
    val immutable = "Immutable"
    println(s"$immutable")

    //    immutable = "Change immutable" // compile error
    //    println(s"$immutable")
  }
}

object SideEffect {
  var total = 0

  def main(args: Array[String]) {
    var add = (x: Int) => {
      total += x
      total
    }

    printf("total = %s \n", add(1))
    printf("total = %s \n", add(1))
    printf("total = %s \n", add(1))
  }
}
