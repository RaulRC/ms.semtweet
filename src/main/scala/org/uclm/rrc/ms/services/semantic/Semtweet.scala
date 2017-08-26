package org.uclm.rrc.ms.services.semantic
import java.util.logging.Logger

import akka.actor.ActorSystem
import akka.stream.Materializer
import org.apache.jena.rdf.model.{Model, ModelFactory}
import org.uclm.rrc.ms.models.Tweet

import scala.concurrent.ExecutionContextExecutor

trait Semtweet {

  private[this] val logger = Logger.getLogger(getClass().getName())

  implicit val system: ActorSystem
  implicit def executor: ExecutionContextExecutor
  implicit val materializer: Materializer

  def semTweet(tweet: Tweet): Model = {
    var resultModel = ModelFactory.createDefaultModel()

    resultModel
  }

}
