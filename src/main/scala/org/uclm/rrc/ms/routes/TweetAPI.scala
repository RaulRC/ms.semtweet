package org.uclm.rrc.ms.routes

import java.util.logging.Logger

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives.SecurityDirectives
import org.uclm.rrc.ms.mappings.JsonMappings
import org.uclm.rrc.ms.models.ResultServiceTweet

trait TweetAPI extends JsonMappings with SecurityDirectives {

  private[this] val logger = Logger.getLogger(getClass().getName())

  val tweetAPI = pathPrefix("free") {
    //assert(dataSet.isInstanceOf[String])
    var messageResult: ResultServiceTweet = null
    pathEndOrSingleSlash {
      post {
        entity(as[String]) { bodyMessage =>
          logger.info("[AUTH] Entry petition")
          messageResult = new ResultServiceTweet("MS_SemTweet", s"received $bodyMessage")
          complete(OK -> messageResult)
        }
      }
    }
  }
}


