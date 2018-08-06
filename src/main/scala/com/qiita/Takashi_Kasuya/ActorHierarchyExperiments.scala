// https://qiita.com/Takashi_Kasuya/items/9351bebb0d76516d3dd4
package com.qiita.Takashi_Kasuya

import akka.actor.{ Actor, Props, ActorSystem }
import akka.event.Logging
import scala.io.StdIn

class PrintMyActorRefActor extends Actor {

  val log = Logging(context.system, this)

  override def preStart(): Unit = log.info("actor started")
  override def postStop(): Unit = log.info("actor stopped")

  override def receive: Receive = {
    case "hello" ⇒
      log.info("Hello world")
    case "child" =>
      val secondRef = context.actorOf(Props[PrintMyActorRefActor], "second-actor")
      println(s"$secondRef")
      secondRef ! "hello"
  }
}

object ActorHierarchyExperiments extends App {
  val system = ActorSystem("testSystem")

  val firstRef = system.actorOf(Props[PrintMyActorRefActor], "first-actor")

  firstRef ! "hello"
  firstRef ! "child"

  println(">>> Press ENTER to exit <<<")
  try StdIn.readLine()
  finally system.terminate()
}
