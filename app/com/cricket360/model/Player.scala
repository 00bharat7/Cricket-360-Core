package com.cricket360.model

import com.mongodb.BasicDBObject

/**
  * Created by bkasinadhuni on 9/16/18.
  */
case class Player(playerId: String, firstName:String, lastName:String, email:String, phone:Long, style:String, alias:String)

case class Players(count: Option[Int], players: List[Player])
