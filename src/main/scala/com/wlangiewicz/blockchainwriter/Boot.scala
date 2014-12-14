package com.wlangiewicz.blockchainwriter

import akka.actor.{ ActorSystem, Props }
import akka.io.IO
import spray.can.Http

object Boot extends App {
  implicit val system = ActorSystem("blockchain-writer")

  val service = system.actorOf(Props[WalletServiceActor], "service")

  IO(Http) ! Http.Bind(service, "0.0.0.0", port = 8080)
}