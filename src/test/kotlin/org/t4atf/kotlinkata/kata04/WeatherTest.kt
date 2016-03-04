package org.t4atf.kotlinkata.kata04

import org.assertj.core.api.Assertions
import org.junit.gen5.api.Test

class WeatherTest {

    @Test fun testLoad() {
        val list = load<WeatherLine>("kata04/weather.dat")
                .invoke(selector, domainMapper)

        Assertions.assertThat(list).containsExactly(
                WeatherLine(1, 88.0, 59.0, 74.0),
                WeatherLine(2, 79.0, 63.0, 71.0),
                WeatherLine(3, 77.0, 55.2, 66.0),
                WeatherLine(4, 77.0, 61.0, 69.0)
        )
    }
}