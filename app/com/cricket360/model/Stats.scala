package com.cricket360.model

/**
  * Created by bkasinadhuni on 9/27/18.
  */

case class Stats(stats: StatsByPlayer)

case class StatsByPlayer(playerId: String, battingStats: BatStats, bowlingStats: BowlStats, fieldingStats: FieldStats, wins: Int, totalCredits: Int)

case class BatStats(
                         matchesPlayed: Int,
                         inningsPlayed: Int,
                         notOuts: Int,
                         runs: Int,
                         balls: Int,
                         average: Double,
                         strikeRate: Double,
                         highestScore: Int,
                         prevHighestScore: Int,
                         hundreds: Int,
                         fifties: Int,
                         thirties: Int,
                         duckOuts: Int,
                         fours: Int,
                         sixes: Int,
                         credits: Int
                       )

case class BowlStats(
                         matchesPlayed: Int,
                         inningsPlayed: Int,
                         overs: Int,
                         runs: Int,
                         wickets: Int,
                         average: Double,
                         economy: Double,
                         strikeRate: Double,
                         threeWicketHaul: Int,
                         fourWicketHaul: Int,
                         fiveWicketHaul: Int,
                         wides: Int,
                         noBalls: Int,
                         credits: Int
                       )

case class FieldStats(
                          catchesTaken: Int,
                          catchesDropped: Int,
                          runOuts: Int,
                          credits: Int
                        )