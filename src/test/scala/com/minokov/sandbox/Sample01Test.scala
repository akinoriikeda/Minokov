package com.minokov.sandbox
import org.scalatest._

class Sample01Test extends FlatSpec with BeforeAndAfterEach {

  case class Result(result: Int, stdout: List[String], stderr: List[String])

  def exec(command: Seq[String]) = {
    import scala.language.postfixOps
    import scala.collection.mutable.ArrayBuffer
    import scala.sys.process.{Process, ProcessLogger}

    val stdout: ArrayBuffer[String] = ArrayBuffer[String]()
    val stderr: ArrayBuffer[String] = ArrayBuffer[String]()

    val logger = ProcessLogger(
      (out: String) => stdout += out,
      (err: String) => stderr += err
    )

    val result = Process(command) ! logger

    Result(result, stdout.toList, stderr.toList)
  }

  override def beforeEach(): Unit = {
//    val result = exec(Seq("ls", "./", "src"))
    val result = exec(Seq("ls"))
    println(result)
  }

  override def afterEach(): Unit = {

  }

  "Sample01.smaple1_01" should "upper case" in {
    assert((new Sample01).smaple1_01("aaa").equals("AAA"))
  }

}
