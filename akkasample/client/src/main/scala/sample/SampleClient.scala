package sample

import scala.concurrent.duration._
import akka.util
import akka.pattern.ask

object SampleClient extends App {
  val ck = new ClientKernel

  implicit val timeout = util.Timeout(55 seconds)
  ck.mediator ? (ck.clientProducer, "HELLO")
}