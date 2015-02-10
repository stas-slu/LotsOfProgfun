package sample

import akka.actor.Actor
import akka.camel.{CamelMessage, Producer}

class ClientProducer extends Actor with Producer {
  //def endpointUri = "http://localhost:8778"
  def endpointUri = "http://0.0.0.0:8778"

  override protected def transformResponse(msg: Any) = {
    msg match {
      case cm:CamelMessage => {
        cm.bodyAs[String]
      }
      case _ => {
        super.transformResponse(msg)
      }
    }
  }
}