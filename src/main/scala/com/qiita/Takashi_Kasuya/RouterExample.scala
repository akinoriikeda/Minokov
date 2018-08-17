// https://qiita.com/Takashi_Kasuya/items/b80e872fa70368b7a27c

package com.qiita.Takashi_Kasuya

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.routing.BalancingPool

import scala.io.StdIn

class PrintMyActorRefActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case "hello" ⇒
      log.info("Hello world")
  }
}

object RouterExample extends App {

  val system = ActorSystem("testSystem")
  val router = system.actorOf(BalancingPool(5).props(Props[PrintMyActorRefActor]), "poolRouter")

  for (i <- 1 to 100) {
    router ! "hello"
  }

  println(">>> Press ENTER to exit <<<")
  try StdIn.readLine()
  finally system.terminate()
}

// application.conf
// akka.actor.deployment {
//   /poolRouter {
//     router = balancing-pool
//     nr-of-instances = 5
//   }
// }
// val system = ActorSystem("testSystem")
// val router = system.actorOf(FromConfig.props(Props[PrintMyActorRefActor]), "poolRouter")
