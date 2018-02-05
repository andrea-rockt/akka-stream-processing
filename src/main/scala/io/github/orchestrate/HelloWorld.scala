package io.github.orchestrate

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.Await


class HelloWorldActor extends Actor with ActorLogging {

  val logger = LoggerFactory.getLogger(classOf[HelloWorldActor])

  override def receive: Receive = {
    case ("Greet", who) =>
      logger.info("logged to logback")
      sender() ! s"Hello world $who"
  }

}


object HelloWorld extends App {

  val system = ActorSystem("orchestrate")

  val ref = system.actorOf(Props(new HelloWorldActor))

  ref ! ("Greet", "Andrea")

  import scala.concurrent.duration._

  Await.result(system.whenTerminated, 4.hours)

}
