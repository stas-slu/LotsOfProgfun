package sample

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object SampleServer extends App {
  val system = ActorSystem("demo", ConfigFactory.load.getConfig("server"))
  val httpConsumer = system.actorOf(Props[ServerConsumer], "httpConsumer")
}
