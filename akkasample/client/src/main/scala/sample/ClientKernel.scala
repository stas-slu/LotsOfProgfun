package sample

import akka.kernel.Bootable
import akka.actor.{Props, ActorSystem}
import com.typesafe.config.ConfigFactory

class ClientKernel extends Bootable {
  val system = ActorSystem("sample", ConfigFactory.load.getConfig("client"))
  val clientProducer = system.actorOf(Props[ClientProducer])
  val mediator = system.actorOf(Props[Mediator])

  def startup() {

  }

  def shutdown() {
    system.shutdown()
  }
}
