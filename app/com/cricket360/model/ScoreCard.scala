package com.cricket360.model
import java.util.Date


/**
  * Created by bkasinadhuni on 9/25/18.
  */

case class Scores(count: Option[Int], scores: List[Score])

case class Score(gameId: String, result: Result, scoreCard: List[ScoreCard], updatedAt: Date)

case class Result(homeTeam: String, oppTeam: String, season: String, matchType: String, matchDate: Date, location: String, tossResult: String, tossDecision: String, winner: String, details: String)

case class ScoreCard(player: Player, batting: Batting, bowling: Bowling, fielding: Fielding)

case class Batting (
                     runsScored: Int,
                     ballsPlayed: Int,
                     dismissalType: String,
                     SR: Double,
                     sixes: Int,
                     fours: Int,
                     isNotOut: Boolean,
                     isDuck: Boolean
                   )

case class Bowling (
                     oversBowled: Int,
                     wicketsTaken: Int,
                     runsGiven: Int,
                     economyRate: Double,
                     noBalls: Int,
                     wideBalls: Int,
                     maidenOvers: Int
                   )

case class Fielding (
                      catchesTaken: Int,
                      catchesDropped: Int,
                      runOuts: Int
                    )
