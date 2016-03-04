package org.t4atf.kotlinkata.kata04

import org.assertj.core.api.Assertions
import org.junit.gen5.api.Test
import org.mockito.Mockito

class WeatherTest {

    @Test fun testLoad() {
        val list = load<WeatherLine>("kata04/weather.dat")
                .invoke(weatherSelector, weatherDomainMapper)

        Assertions.assertThat(list).containsExactly(
                WeatherLine(1, 88.0, 59.0, 74.0),
                WeatherLine(2, 79.0, 63.0, 71.0),
                WeatherLine(3, 77.0, 55.2, 66.0),
                WeatherLine(4, 77.0, 61.0, 69.0)
        )
    }

    @Test fun noDays() {
        val minSpreads = weatherMunging(listOf())

        Assertions.assertThat(minSpreads).isEmpty()
    }

    @Test fun findSmallestSpread() {
        val minSpreads = weatherMunging(listOf(
                WeatherLine(1, 20.0, 10.0, 15.0),
                WeatherLine(2, 20.0, 12.0, 16.0),
                WeatherLine(3, 10.0, -2.0, 4.0),
                WeatherLine(4, 30.0, 10.0, 20.0)
        ))

        Assertions.assertThat(minSpreads).containsOnly(Pair(2, 8.0))
    }

    @Test fun multipleDaysWithSameMinimumSpread() {
        val minSpreads = weatherMunging(listOf(
                WeatherLine(1, 20.0, 12.0, 16.0),
                WeatherLine(2, 22.0, 14.0, 18.0),
                WeatherLine(3, 10.0, -2.0, 4.0),
                WeatherLine(4, 30.0, 10.0, 20.0)
        ))

        Assertions.assertThat(minSpreads).containsOnly(Pair(2, 8.0), Pair(1, 8.0))
    }

    @Test fun print() {
        val out = Mockito.spy(System.out)
        print(listOf(
                Pair(1, 8.0),
                Pair(2, 8.0),
                Pair(3, 12.0),
                Pair(4, 20.0)
        ), out, weatherOutFormatter)

        Mockito.verify(out).println("Minimal spread of 8.0 found in day 1")
        Mockito.verify(out).println("Minimal spread of 8.0 found in day 2")
    }
}