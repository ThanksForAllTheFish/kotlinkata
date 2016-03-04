package org.t4atf.kotlinkata.kata04

val footballSelector = fun (line: String) = isNumber(line.trim().split(" ").getOrElse(0) { "" }.removeSuffix("."))

val footballDomainMapper = { line : String -> toFootballLine(line.split(" ").filterNot { s -> s.isBlank() }) }

val footballMunging = fun(teams: List<FootballLine>) = munging(teams,
        { team: FootballLine -> Math.abs(team.forGoals - team.againstGoals) },
        { team: FootballLine -> Pair(team.team, team.forGoals - team.againstGoals) })

val footballOutFormatter = fun(team: String, difference: Int) = "Minimal difference is $difference for $team"

private fun toFootballLine(line: List<String>) = FootballLine(line[1], line[6].toInt(), line[8].toInt())

