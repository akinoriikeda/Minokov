//package com.minokov.sandbox
//
//import org.junit.runner.RunWith
//
//import org.specs2.mutable.Specification
//import org.specs2.runner.JUnitRunner
//import org.specs2.specification.Scope
//import org.specs2.mock.Mockito
//
//@RunWith(classOf[JUnitRunner])
//class Sample01Spec extends Specification with Mockito {
//
//
//  "def: smaple1_01 001" should {
//
//    "success 1" in new WithFixture {
//      val s = new Sample01
//      val r = s.smaple1_01("hoge")
//      r must_== "HOGE"
//    }
//
//    "error 1" in new WithFixture {
//      val s = new Sample01
//      val r = s.smaple1_01("hoge")
//      r must_!= "hoge"
//    }
//  }
//
//
//  trait WithFixture extends Scope {
//
//  }
//
//}
