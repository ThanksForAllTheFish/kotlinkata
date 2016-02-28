package org.t4atf.kotlinkata.kata04

import org.assertj.core.api.Assertions
import org.junit.gen5.api.Test

class FullWeatherLineFileLoaderTest {

    val loader = FullWeatherLineFileLoader()

    @Test fun testLoad() {
        val list = loader.load("kata04/weather.dat")

        Assertions.assertThat(list).containsExactly(
                WeatherLine(1, 88.0, 59.0, 74.0),
                WeatherLine(2, 79.0, 63.0, 71.0),
                WeatherLine(3, 77.0, 55.2, 66.0)
        )
    }
}