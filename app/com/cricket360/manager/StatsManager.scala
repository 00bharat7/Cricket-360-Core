package com.cricket360.manager

import com.cricket360.connection.MongoConnector
import com.cricket360.helpers.StatsHelper
import com.cricket360.model.Stats
import com.mongodb.casbah.commons.MongoDBObject
import com.sun.media.sound.InvalidDataException

import scala.concurrent.Future

/**
  * Created by bkasinadhuni on 9/27/18.
  */
object StatsManager {

  def getStatsById(playerId: String) = {
        val statsFromDB = MongoConnector.stats.findOne(MongoDBObject("playerId" -> playerId))
        val stats = statsFromDB.map(StatsHelper.convertDBObjectToStats(_))
      val dbResult =stats.map(Stats(_))


    val response= if(!dbResult.isDefined) Left(new InvalidDataException("No Stats available")) else Right(dbResult.get)

    Future.successful(response)
  }

}
