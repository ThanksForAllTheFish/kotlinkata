package org.t4atf.kotlinkata.kata04

fun main(args: Array<String>) {
    application(weatherMunging, load<WeatherLine>("kata04/weather.dat").invoke(weatherSelector, weatherDomainMapper), weatherOutFormatter)
    application(footballMunging, load<FootballLine>("kata04/football.dat").invoke(footballSelector, footballDomainMapper), footballOutFormatter)
}

private fun <T, L, R> application(munging: (List<T>) -> List<Pair<L, R>>, loader: List<T>, outFormatter: (L, R) -> String) =
        print(munging.invoke(loader), System.out, outFormatter)
