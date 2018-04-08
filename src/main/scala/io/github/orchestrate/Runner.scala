package io.github.orchestrate

import akka.actor.ActorSystem

object Runner {
  def main(args:Array[String]): Unit = {

    val system = ActorSystem("orchestrate")


    system.registerOnTermination(System.exit(0))

  }
}
