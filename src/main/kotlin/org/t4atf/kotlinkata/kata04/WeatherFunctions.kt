package org.t4atf.kotlinkata.kata04

val weatherSelector = fun (line: String) = isNumber(line.trim().split(" ").getOrElse(0) { "" })

val weatherDomainMapper = { line : String -> toWeatherLine(line.split(" ").filterNot { s -> s.isBlank() }) }

val weatherMunging = fun (days : List<WeatherLine>) = munging(days,
        { day -> day.maxTmp - day.minTmp },
        { day -> Pair(day.day, day.maxTmp - day.minTmp) })

val weatherOutFormatter = fun(day: Int, spread: Double) = "Minimal spread of $spread found in day $day"

private fun toWeatherLine(line: List<String>) = WeatherLine(
        removeLastCharacterIfMarker(line[0]).toInt(),
        removeLastCharacterIfMarker(line[1]).toDouble(),
        removeLastCharacterIfMarker(line[2]).toDouble(),
        removeLastCharacterIfMarker(line[3]).toDouble())

private fun removeLastCharacterIfMarker(s: String) = if(s.last() == '*') s.removeSuffix("*") else s
