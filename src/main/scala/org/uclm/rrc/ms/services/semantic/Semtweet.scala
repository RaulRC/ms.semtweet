package org.uclm.rrc.ms.services.semantic
import java.io.IOException
import java.util.logging.Logger

import akka.actor.ActorSystem
import akka.stream.Materializer
import org.apache.jena.ontology.{OntModel, OntModelSpec}
import org.apache.jena.rdf.model.{Model, ModelFactory}
import org.apache.jena.util.FileManager
import org.uclm.rrc.ms.models.Tweet

import scala.concurrent.ExecutionContextExecutor

trait Semtweet {

  private[this] val logger = Logger.getLogger(getClass().getName())

  implicit val system: ActorSystem
  implicit def executor: ExecutionContextExecutor
  implicit val materializer: Materializer

  val ontFile = "ontology/semtweets.owl"
  val TWEET = "Tweet"
  val USER = "User"
  val COORD = "Coordinates"
  val HASH = "Hashtag"

  def semTweet(tweet: Tweet): Model = {
    var resultModel = ModelFactory.createDefaultModel()
    val ontTweet  = getOntologyModel(ontFile)
    var cTweet = ontTweet.getOntClass(TWEET)
    var cUser = ontTweet.getOntClass(USER)
    var cCoords = ontTweet.getOntClass(COORD)
    var cHash = ontTweet.getOntClass(HASH)



    resultModel
  }

  def getOntologyModel(ontFile: String): OntModel = {
    var ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null)
    try{
      val in = FileManager.get().open(ontFile)
      ontoModel.read(in, null)
    }
    catch {
      case ioe: IOException => ioe.printStackTrace()
    }
    ontoModel
  }

}
