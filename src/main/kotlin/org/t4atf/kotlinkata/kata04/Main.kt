package org.t4atf.kotlinkata.kata04

fun main(args: Array<String>) {
    application(munging, load("kata04/weather.dat"))
}

private fun application(munging: (List<WeatherLine>) -> List<Pair<Int, Double>>, loader: (selector: (String) -> Boolean, domainMapper: (String) -> WeatherLine) -> List<WeatherLine>) =
        print(munging, loader.invoke(selector, domainMapper), System.out)
