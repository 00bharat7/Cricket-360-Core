package com.cricket360.manager

import com.cricket360.connection.MongoConnector
import com.cricket360.helpers.ScoreCardHelper
import com.cricket360.model.Scores
import com.mongodb.casbah.commons.MongoDBObject
import com.sun.media.sound.InvalidDataException

import scala.concurrent.Future

/**
  * Created by bkasinadhuni on 9/25/18.
  */
object ScoreCardManager {

  def getScoreById(gameId: Option[String]) = {
    val dbResult = gameId match {
      case Some(id) =>
        val scoreCardsFromDB = MongoConnector.scores.find(MongoDBObject("gameId" -> id))
        val scoreCardList = scoreCardsFromDB.map(ScoreCardHelper.convertDBObjectToScore(_)).toList
        Scores(Option(scoreCardList.size), scoreCardList)

      case None =>
        val scoreCardsFromDB = MongoConnector.scores.find
        val scoreCardList = scoreCardsFromDB.map(ScoreCardHelper.convertDBObjectToScore(_)).toList
        Scores(Option(scoreCardList.size), scoreCardList)
    }

    val response= if(dbResult.scores.size == 0) Left(new InvalidDataException("No players available")) else Right(dbResult)

    Future.successful(response)
  }

}
