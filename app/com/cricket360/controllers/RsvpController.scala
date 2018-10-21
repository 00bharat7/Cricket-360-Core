package com.cricket360.controllers

import akka.actor.ActorSystem
import com.cricket360.manager.RsvpManager
import com.cricket360.model.Rsvp
import javax.inject.Inject
import net.liftweb.json.DefaultFormats
import net.liftweb.json.Serialization.write
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by bkasinadhuni on 10/5/18.
  */
class RsvpController @Inject()(cc: ControllerComponents, actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends AbstractController(cc){
  implicit val formats = DefaultFormats

  def fetchOrUpdateRsvp(gameId: String, email: Option[String], vote: Option[String]) = Action.async{ request =>
    val players: Future[Either[Exception, Rsvp]] = RsvpManager.getRsvpsByGameId(gameId, email, vote)
    players.map(i => i match {
      case Right(x) => Ok(write(x))
      case Left(e) => BadRequest(e.getMessage)
    })
  }
}
