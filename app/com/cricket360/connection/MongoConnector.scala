package com.cricket360.connection

import com.cricket360.model.Player
import com.mongodb.casbah.MongoConnection
/**
  * Created by bkasinadhuni on 9/16/18.
  */
object MongoConnector {

  private val SERVER = "localhost"
  private val PORT   = 27017

  private val DATABASE = "cricket360"

  private val COLLECTION1 = "scores"
  private val COLLECTION2 = "players"
  private val COLLECTION3 = "stats"
  private val COLLECTION4 = "rsvps"

  val connection = MongoConnection(SERVER)
  val scores = connection(DATABASE)(COLLECTION1)
  val players= connection(DATABASE)(COLLECTION2)
  val stats= connection(DATABASE)(COLLECTION3)
  val rsvps= connection(DATABASE)(COLLECTION4)

}
