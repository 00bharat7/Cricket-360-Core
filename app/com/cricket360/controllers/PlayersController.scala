package com.cricket360.controllers

import akka.actor.ActorSystem
import com.cricket360.manager.PlayersManager
import com.cricket360.model.{Player, Players}
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import net.liftweb.json._
import net.liftweb.json.Serialization.write

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by bkasinadhuni on 9/16/18.
  */

@Singleton
class PlayersController @Inject()(cc: ControllerComponents, actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends AbstractController(cc){
  implicit val formats = DefaultFormats

  def fetchPlayerById(playerId:Option[String]) = Action.async{ request =>
    val players: Future[Either[Exception, Players]] = PlayersManager.getPlayerById(playerId)
    players.map(i => i match {
      case Right(x) => Ok(write(x))
      case Left(e) => BadRequest(e.getMessage)
    })
  }
}
