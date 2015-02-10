package sample

import akka.camel.{CamelMessage, Consumer}

class ServerConsumer extends Consumer {
  def endpointUri = "jetty://http://0.0.0.0:8778"

  def receive = {
    case msg : CamelMessage => {
      println("Got %s from the client" format msg.bodyAs[String])
      sender ! ("Got %s from the client" format msg.bodyAs[String])
    }
  }
}
