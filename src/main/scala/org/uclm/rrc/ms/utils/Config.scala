package org.uclm.rrc.ms.utils

trait Config {
  val httpInterface = System.getenv("SEMTWEET_HTTP_INTERFACE")
  val httpPort = System.getenv("SEMTWEET_HTTP_PORT").toInt
}
