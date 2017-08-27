package org.uclm.rrc.ms.routes

import java.util.logging.Logger

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives.SecurityDirectives
import org.uclm.rrc.ms.mappings.JsonMappings
import org.uclm.rrc.ms.models.{ResultServiceTweet, Tweet}
import spray.json._
import DefaultJsonProtocol._
import org.uclm.rrc.ms.services.semantic.Semtweet


trait TweetAPI extends JsonMappings with SecurityDirectives with Semtweet{

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
            val model = semTweet(tweet)
            logger.info("[MS_SEMTWEET] received tweet: " + tweet.id)
            logger.info("[MS_SEMTWEET] received tweet\n: " + tweet.text)
            messageResult = new ResultServiceTweet("MSSEMTWEET_200", model.getGraph().toString())
            complete(OK -> messageResult)
          }
        }
      }
    }
  }
}


