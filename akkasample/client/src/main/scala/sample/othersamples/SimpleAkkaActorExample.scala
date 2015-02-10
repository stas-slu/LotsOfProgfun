package sample.othersamples

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _       => println("huh?")
  }
}

// (1) changed the constructor here
class HelloActorWithParameter(myName: String) extends Actor {
  def receive = {
    // (2) changed these println statements
    case "hello" => println("hello from %s".format(myName))
    case _       => println("'huh?', said %s".format(myName))
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  // default Actor constructor
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  // Actor constructor with parameter
  val helloActorWithParameter = system.actorOf(Props(new HelloActorWithParameter("Fred")), name = "helloactorwithparameter")

  helloActor ! "hello"
  helloActor ! "buenos dias"

  helloActorWithParameter ! "hello"
  helloActorWithParameter ! "buenos dias"
}

