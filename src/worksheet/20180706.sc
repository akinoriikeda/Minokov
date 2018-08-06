// http://d.hatena.ne.jp/kaoskfos/20120416/p1

import scala.annotation.tailrec

object Test1 {
  @tailrec
  def sum(acc: Int, list: List[Int]): Int = {
    print("acc = " + acc + "\n")
    list match {
      case Nil => acc
      case e :: es =>
        print("es = " + es + "\n")
        sum(acc + e, es)
    }
  }

  def main(args: Array[String]) = {
    val list = List(1, 2, 3, 4, 5, 6, 7)
    val result = sum(list.head, list.tail)
    println("result: " + result + "\n")
  }
}

Test1.main((Array("")))
