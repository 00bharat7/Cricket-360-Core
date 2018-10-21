package com.cricket360.helpers

import java.util.Date

import com.cricket360.model._
import com.mongodb.{BasicDBList, DBObject}
import com.mongodb.casbah.Imports._

/**
  * Created by bkasinadhuni on 9/25/18.
  */
object ScoreCardHelper {

  def convertDBObjectToScore(dbObject: DBObject) = {
    Score(
      dbObject.get("gameId").asInstanceOf[String],
      convertDbObjectToResult(dbObject.get("result").asInstanceOf[DBObject]),
      convertDbListtoScorecard(dbObject.get("scoreCard").asInstanceOf[BasicDBList]),
      dbObject.get("updatedAt").asInstanceOf[Date]
    )
  }

  def convertDbObjectToResult(dBObject: DBObject): Result = {
    Result(
      dBObject.get("homeTeam").asInstanceOf[String],
      dBObject.get("oppTeam").asInstanceOf[String],
      dBObject.get("season").asInstanceOf[String],
      dBObject.get("matchType").asInstanceOf[String],
      dBObject.get("matchDate").asInstanceOf[Date],
      dBObject.get("location").asInstanceOf[String],
      dBObject.get("tossResult").asInstanceOf[String],
      dBObject.get("tossDecision").asInstanceOf[String],
      dBObject.get("winner").asInstanceOf[String],
      dBObject.get("details").asInstanceOf[String]
    )
  }

  def convertDbListtoScorecard(dbList: BasicDBList): List[ScoreCard] = {
   dbList.map(
     dbObject => {
       val dbObj = dbObject.asInstanceOf[DBObject]
     ScoreCard(
       PlayerHelper.convertDBObjectToPlayer(dbObj.get("player").asInstanceOf[DBObject]),
       convertDBObjectToBatting(dbObj.get("batting").asInstanceOf[DBObject]),
       convertDBObjectToBowling(dbObj.get("bowling").asInstanceOf[DBObject]),
       convertDBObjectToFielding(dbObj.get("fielding").asInstanceOf[DBObject])
     )
   }).toList
  }

  def convertDBObjectToBatting(dBObject: DBObject): Batting = {
    Batting(
      dBObject.get("runsScored").asInstanceOf[Int],
      dBObject.get("ballsPlayed").asInstanceOf[Int],
      dBObject.get("dismissalType").asInstanceOf[String],
      dBObject.get("SR").asInstanceOf[Double],
      dBObject.get("sixes").asInstanceOf[Int],
      dBObject.get("fours").asInstanceOf[Int],
      dBObject.get("isNotOut").asInstanceOf[Boolean],
      dBObject.get("isDuck").asInstanceOf[Boolean]
    )
  }

  def convertDBObjectToBowling(dBObject: DBObject): Bowling = {
    Bowling(
      dBObject.get("oversBowled").asInstanceOf[Int],
      dBObject.get("wicketsTaken").asInstanceOf[Int],
      dBObject.get("runsGiven").asInstanceOf[Int],
      dBObject.get("economyRate").asInstanceOf[Double],
      dBObject.get("noBalls").asInstanceOf[Int],
      dBObject.get("wideBalls").asInstanceOf[Int],
      dBObject.get("maidenOvers").asInstanceOf[Int]
    )

  }

  def convertDBObjectToFielding(dBObject: DBObject): Fielding = {
    Fielding(
      dBObject.get("catchesTaken").asInstanceOf[Int],
      dBObject.get("catchesDropped").asInstanceOf[Int],
      dBObject.get("runOuts").asInstanceOf[Int]
    )

  }

}
