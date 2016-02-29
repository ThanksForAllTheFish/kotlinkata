package org.t4atf.kotlinkata.kata04

import java.io.PrintStream

val munging = fun (days : List<WeatherLine>) = days
            .groupBy { day -> day.maxTmp - day.minTmp }
            .toSortedMap()
            .map { entry -> entry.value }
            .firstOrNull()
            ?.map { day -> Pair(day.day, day.maxTmp - day.minTmp) }
            .orEmpty()

fun print(munging : (List<WeatherLine>) -> List<Pair<Int, Double>>, days : List<WeatherLine>, out : PrintStream) {
    for ((day, spread) in munging.invoke(days)) {
        out.println("Minimal spread of $spread found in day $day")
    }
}