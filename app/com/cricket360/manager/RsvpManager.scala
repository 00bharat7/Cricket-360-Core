package com.cricket360.manager

import com.cricket360.connection.MongoConnector
import com.cricket360.helpers.RsvpHelper
import com.mongodb.casbah.commons.MongoDBObject
import com.sun.media.sound.InvalidDataException
import com.mongodb.casbah.Imports._

import scala.concurrent.Future

/**
  * Created by bkasinadhuni on 10/8/18.
  */
object RsvpManager {

  def getRsvpsByGameId(gameId: String, email: Option[String], vote: Option[String]) = {
    val rsvpResponse = if(email.isDefined && vote.isDefined){
      val emailId = email.get
      val playerVote = vote.get
      // store or update new rsvp
      val playerId = MongoConnector.players.findOne(MongoDBObject("email" -> emailId)).map(_.get("playerId").asInstanceOf[String])

      val rsvpRquest = MongoDBObject("gameId" -> gameId, "vote" -> playerVote, "email" -> emailId, "playerId" -> playerId.getOrElse(""))
      val updateQuery = MongoDBObject("email" -> emailId)
      MongoConnector.rsvps.findAndModify(updateQuery, DBObject(), DBObject(),false, rsvpRquest, false, true)

      // get all rsvps by gameId
      RsvpHelper.fetchRsvps(gameId)

    }else{
      // get all rsvps by gameId
      RsvpHelper.fetchRsvps(gameId)
    }

    val response = if(rsvpResponse.votes.size == 0) Left(new InvalidDataException("No rsvps available")) else Right(rsvpResponse)
    Future.successful(response)
  }
}
