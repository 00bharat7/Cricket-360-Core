package com.cricket360.manager

import com.cricket360.connection.MongoConnector
import com.cricket360.helpers.PlayerHelper
import com.cricket360.model.Players
import com.mongodb.casbah.Imports.MongoDBObject
import com.sun.media.sound.InvalidDataException

import scala.concurrent.Future

/**
  * Created by bkasinadhuni on 9/16/18.
  */
object PlayersManager {

  def getPlayerById(playerId: Option[String]) = {
    val dbResult = playerId match {
      case Some(id) =>
        val playersFromDB = MongoConnector.players.find(MongoDBObject("playerId" -> id))
        val playerList = playersFromDB.map(PlayerHelper.convertDBObjectToPlayer(_)).toList
        Players(Option(playerList.size), playerList)

      case None =>
        val playersFromDB = MongoConnector.players.find
        val playerList = playersFromDB.map(PlayerHelper.convertDBObjectToPlayer(_)).toList
        Players(Option(playerList.size), playerList)
    }

    val response= if(dbResult.players.size == 0) Left(new InvalidDataException("No players available")) else Right(dbResult)

    Future.successful(response)
  }

}
