package com.cricket360.helpers

import com.cricket360.model.Player
import com.mongodb.DBObject

/**
  * Created by bkasinadhuni on 9/17/18.
  */
object PlayerHelper {

  def convertDBObjectToPlayer(dbObject: DBObject) = {
    Player(
      dbObject.get("playerId").asInstanceOf[String],
      dbObject.get("firstName").asInstanceOf[String],
      dbObject.get("lastName").asInstanceOf[String],
      dbObject.get("email").asInstanceOf[String],
      dbObject.get("phone").asInstanceOf[Long],
      dbObject.get("style").asInstanceOf[String],
      dbObject.get("alias").asInstanceOf[String]
    )
  }
}
