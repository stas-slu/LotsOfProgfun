package sample

import akka.actor.{ActorRef, Actor}
import akka.camel.CamelMessage

class Mediator extends Actor {
  def receive = {
    case (actor: ActorRef, msg: String) => {
      actor ! CamelMessage(msg, Map.empty)
    }
    case msg: CamelMessage => {
      println("Got camel message: %s" format msg.body)
    }
    case transformedMsg: String => {
      println("Got transformed msg: %s" format transformedMsg)
    }
    case _ => {
      println("Got something else")
    }
  }
}