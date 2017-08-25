package org.uclm.rrc.ms.routes

import java.util.logging.Logger

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives.SecurityDirectives
import org.uclm.rrc.ms.mappings.JsonMappings
import org.uclm.rrc.ms.models.{ResultServiceTweet, Tweet}
import spray.json._
import DefaultJsonProtocol._


trait TweetAPI extends JsonMappings with SecurityDirectives {

  private[this] val logger = Logger.getLogger(getClass().getName())

  val tweetAPI = pathPrefix("tweet") {
    //assert(dataSet.isInstanceOf[String])
    var messageResult: ResultServiceTweet = null
    pathEndOrSingleSlash {
      post {
        entity(as[String]) { bodyMessage =>
          entity(as[String]) { fieldsToConsume =>
            val jsonMessage : JsValue = fieldsToConsume.parseJson
            val tweet = jsonMessage.convertTo[Tweet]
            messageResult = new ResultServiceTweet("MS_SemTweet", s"received $jsonMessage.")
            complete(OK -> messageResult)
          }
        }
      }
    }
  }
}


