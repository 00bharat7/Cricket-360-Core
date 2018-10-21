package com.cricket360.helpers

import com.cricket360.model.{BatStats, BowlStats, FieldStats, StatsByPlayer}
import com.mongodb.DBObject

/**
  * Created by bkasinadhuni on 9/27/18.
  */
object StatsHelper {

  def convertDBObjectToStats(dBObject: DBObject) = {
    StatsByPlayer(
      dBObject.get("playerId").asInstanceOf[String],
      convertDbObjectToBattingStats(dBObject.get("battingStats").asInstanceOf[DBObject]),
      convertDbObjectToBowlingStats(dBObject.get("bowlingStats").asInstanceOf[DBObject]),
      convertDbObjectToFieldingStats(dBObject.get("fieldingStats").asInstanceOf[DBObject]),
      dBObject.get("wins").asInstanceOf[Int],
      dBObject.get("totalCredits").asInstanceOf[Int]
    )
  }

  def convertDbObjectToBattingStats(dBObject: DBObject) = {
    BatStats(
      dBObject.get("matchesPlayed").asInstanceOf[Int],
      dBObject.get("inningsPlayed").asInstanceOf[Int],
      dBObject.get("notOuts").asInstanceOf[Int],
      dBObject.get("runs").asInstanceOf[Int],
      dBObject.get("balls").asInstanceOf[Int],
      dBObject.get("average").asInstanceOf[Double],
      dBObject.get("strikeRate").asInstanceOf[Double],
      dBObject.get("highestScore").asInstanceOf[Int],
      dBObject.get("prevHighestScore").asInstanceOf[Int],
      dBObject.get("hundreds").asInstanceOf[Int],
      dBObject.get("fifties").asInstanceOf[Int],
      dBObject.get("thirties").asInstanceOf[Int],
      dBObject.get("duckOuts").asInstanceOf[Int],
      dBObject.get("fours").asInstanceOf[Int],
      dBObject.get("sixes").asInstanceOf[Int],
      dBObject.get("credits").asInstanceOf[Int]
    )
  }

  def convertDbObjectToBowlingStats(dBObject: DBObject) = {
    BowlStats(
      dBObject.get("matchesPlayed").asInstanceOf[Int],
      dBObject.get("inningsPlayed").asInstanceOf[Int],
      dBObject.get("overs").asInstanceOf[Int],
      dBObject.get("runs").asInstanceOf[Int],
      dBObject.get("wickets").asInstanceOf[Int],
      dBObject.get("average").asInstanceOf[Double],
      dBObject.get("economy").asInstanceOf[Double],
      dBObject.get("strikeRate").asInstanceOf[Double],
      dBObject.get("threeWicketHaul").asInstanceOf[Int],
      dBObject.get("fourWicketHaul").asInstanceOf[Int],
      dBObject.get("fiveWicketHaul").asInstanceOf[Int],
      dBObject.get("wides").asInstanceOf[Int],
      dBObject.get("noBalls").asInstanceOf[Int],
      dBObject.get("credits").asInstanceOf[Int]
    )
  }

  def convertDbObjectToFieldingStats(dBObject: DBObject) = {
    FieldStats(
      dBObject.get("catchesTaken").asInstanceOf[Int],
      dBObject.get("catchesDropped").asInstanceOf[Int],
      dBObject.get("runOuts").asInstanceOf[Int],
      dBObject.get("credits").asInstanceOf[Int]
    )
  }

}
