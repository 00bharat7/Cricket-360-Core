package com.cricket360.controllers

import akka.actor.ActorSystem
import com.cricket360.manager.StatsManager
import com.cricket360.model.Stats
import javax.inject.Inject
import net.liftweb.json.DefaultFormats
import net.liftweb.json.Serialization.write
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by bkasinadhuni on 9/26/18.
  */
class StatsController @Inject()(cc: ControllerComponents, actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends AbstractController(cc){
  implicit val formats = DefaultFormats

  def fetchStats(playerId: String) = Action.async{ request =>
    val players: Future[Either[Exception, Stats]] = StatsManager.getStatsById(playerId)
    players.map(i => i match {
      case Right(x) => Ok(write(x))
      case Left(e) => BadRequest(e.getMessage)
    })
  }
}
