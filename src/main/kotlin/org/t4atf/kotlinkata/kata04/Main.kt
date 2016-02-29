package org.t4atf.kotlinkata.kata04

fun main(args: Array<String>) {
    application(munging, FullWeatherLineFileLoader.LOADER, "kata04/weather.dat")
}

private fun application(munging: (List<WeatherLine>) -> List<Pair<Int, Double>>, loader: (String) -> List<WeatherLine>, location: String) =
        print(munging, loader.invoke(location), System.out)
