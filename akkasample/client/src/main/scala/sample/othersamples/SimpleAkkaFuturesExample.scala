package sample.othersamples

import scala.concurrent.duration._
import java.util.concurrent.Executors

import scala.concurrent.{Await, Future, ExecutionContext}

object Futures extends App {

  val pool = Executors.newCachedThreadPool()
  implicit val ec = ExecutionContext.fromExecutorService(pool)

  // note that the type is properly returned
  val future = Future {
    1 + 1  // you can return other data types, like "Hello world"
  }
  val result = Await.result(future, 1 second)
  println(result)

  pool.shutdown
}