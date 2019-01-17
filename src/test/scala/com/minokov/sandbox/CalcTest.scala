package com.minokov.sandbox
import org.scalatest._
import org.scalatest.concurrent.TimeLimits
import org.scalatest.time.SpanSugar._

class CalcSpec extends FlatSpec with DiagrammedAssertions with TimeLimits {

  val calc = new Calc

  "def sum" should "整数の配列を取得し、それらを足し合わせた整数を返すことができる" in {
    assert(calc.sum(Seq(1, 2, 3)) === 6)
    assert(calc.sum(Seq(0)) === 0)
    assert(calc.sum(Seq(-1, 1)) === 0)
    assert(calc.sum(Seq()) === 0)
  }

  it should "Intの最大を上回った際にはオーバーフローする" in {
    assert(calc.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
  }

  "def div" should "整数を2つ受け取り、分子を分母で割った浮動小数点の値を返す" in {
    assert(calc.div(6, 3) === 2.0)
    assert(calc.div(1, 3) === 0.3333333333333333)
  }

  it should "0で割ろうとした際には実行時例外が投げられる" in {
    intercept[ArithmeticException] {
      calc.div(1, 0)
    }
  }

  "def isPrime" should "その値が素数であるかどうかのブール値を返す" in {
    assert(calc.isPrime(0) === false)
    assert(calc.isPrime(-1) === false)
    assert(calc.isPrime(2))
    assert(calc.isPrime(17))
  }

  it should "100万以下の値の素数判定を一秒以内で処理できる" in {
    failAfter(1000 millis) {
      assert(calc.isPrime(9999991))
    }
  }
}

//import org.scalatest.{BeforeAndAfterEach, FunSuite}

//class CalcTest extends FunSuite with BeforeAndAfterEach {

//  override def beforeEach(): Unit = {
//    println("beforeEach run ...")
//  }
//  override def afterEach(): Unit = {
//    println("afterEach run ...")
//  }
//
//  test("testSum") {
//    println("testSum run ...")
//  }

//  test("testDiv") {
//    println("testDiv run ...")
//  }
//
//  test("testIsPrime") {
//    println("testIsPrime run ...")
//  }

//}
