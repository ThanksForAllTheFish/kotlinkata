package org.t4atf.kotlinkata.kata04

val selector = fun (line: String) : Boolean {
    try {
        line.trim().split(" ").getOrElse(0) { "" }.toDouble()
        return true
    } catch (e : NumberFormatException) {
        return false
    }
}

val domainMapper = { line : String -> toWeatherLine(line.split(" ").filterNot { s -> s.isBlank() }) }

private fun toWeatherLine(line: List<String>) = WeatherLine(
        removeLastCharacterIfMarker(line[0]).toInt(),
        removeLastCharacterIfMarker(line[1]).toDouble(),
        removeLastCharacterIfMarker(line[2]).toDouble(),
        removeLastCharacterIfMarker(line[3]).toDouble())

private fun removeLastCharacterIfMarker(s: String) = if(s.last() == '*') s.removeSuffix("*") else s
