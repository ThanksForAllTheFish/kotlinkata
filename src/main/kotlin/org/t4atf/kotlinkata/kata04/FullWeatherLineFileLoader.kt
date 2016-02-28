package org.t4atf.kotlinkata.kata04

import java.util.*

class FullWeatherLineFileLoader : FileLoader<List<WeatherLine>> {

    override fun load(location: String): List<WeatherLine> {
        val resource = this.javaClass.classLoader.getResourceAsStream(location)
        Scanner(resource).use {
            val scanner = it.useDelimiter(System.lineSeparator())
            val list = listOf<WeatherLine>().toMutableList()
            var i = 0
            while (scanner.hasNext()) {
                val line = scanner.next();
                if(i > 1 && line.isNotBlank()) {
                    list.add(toWeatherLine(line.split(" ").filterNot { s -> s.isBlank() }))
                }
                i++
            }
            return list
        }
    }

    private fun toWeatherLine(line: List<String>) = WeatherLine(
                removeLastCharacterIfMarker(line[0]).toInt(),
                removeLastCharacterIfMarker(line[1]).toDouble(),
                removeLastCharacterIfMarker(line[2]).toDouble(),
                removeLastCharacterIfMarker(line[3]).toDouble())

    private fun removeLastCharacterIfMarker(s: String) = if(s.last() == '*') s.removeSuffix("*") else s

}
