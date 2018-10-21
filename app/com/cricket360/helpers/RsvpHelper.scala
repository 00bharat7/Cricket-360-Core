package com.cricket360.helpers

import com.cricket360.connection.MongoConnector
import com.cricket360.model.{Rsvp, Vote}
import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject

/**
  * Created by bkasinadhuni on 10/8/18.
  */
object RsvpHelper {

  def convertDBObjectToVote(dBObject: DBObject) = {
    Vote(
      dBObject.get("email").asInstanceOf[String],
      dBObject.get("vote").asInstanceOf[String],
      dBObject.get("playerId").asInstanceOf[String]
    )
  }

  def fetchRsvps(gameId: String) = {
    val rsvpsFromDB = MongoConnector.rsvps.find(MongoDBObject("gameId" -> gameId))
    val rsvps = Rsvp(gameId, rsvpsFromDB.size, rsvpsFromDB.map(RsvpHelper.convertDBObjectToVote(_)).toList)
    rsvps
  }

}
