package com.cricket360.controllers

import akka.actor.ActorSystem
import com.cricket360.manager.ScoreCardManager
import com.cricket360.model.Scores
import javax.inject.Inject
import net.liftweb.json.DefaultFormats
import net.liftweb.json.Serialization.write
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by bkasinadhuni on 9/25/18.
  */
class ScoreCardController @Inject()(cc: ControllerComponents, actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends AbstractController(cc){
  implicit val formats = DefaultFormats

  def fetchScoreCardByGameId(gameId:Option[String]) = Action.async{ request =>
    val players: Future[Either[Exception, Scores]] = ScoreCardManager.getScoreById(gameId)
    players.map(i => i match {
      case Right(x) => Ok(write(x))
      case Left(e) => BadRequest(e.getMessage)
    })
  }
}
