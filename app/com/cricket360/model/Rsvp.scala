package com.cricket360.model

/**
  * Created by bkasinadhuni on 10/8/18.
  */

case class Rsvp(gameId: String, count: Int, votes: Seq[Vote])

case class Vote(email: String, vote: String, playerId: String)
