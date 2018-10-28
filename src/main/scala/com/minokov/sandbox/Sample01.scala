package com.minokov.sandbox

class Sample01 {

  val a: String = "A"

  def smaple1_01(aString: String): String = {
    aString.toUpperCase
  }

  a match {
    case "A"     => println(a)
    case "BBBBB" => println("boo")
  }

}

object Sample01
