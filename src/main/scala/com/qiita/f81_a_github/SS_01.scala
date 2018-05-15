package com.qiita.f81_a_github

//https://qiita.com/f81@github/items/369d3ad97112b20d9bc5

//https://qiita.com/f81@github/items/8d67fb3f211fb3e149db

object HellwWorld {

  def main(args: Array[String]): Unit = {
    if (args.size == 0) {
      val strs = Array("Hello, World.")
      output(strs)
    } else {
      printf("Invalid args.")
    }
  }

//  def output(strs: Array[String]): Unit = {
//    for (str <- strs) {
//      printf("%s ", str)
//    }
//  }

  def output(strs: Array[String]): Unit = {
    strs.foreach(printf("%s ", _))
  }
}
