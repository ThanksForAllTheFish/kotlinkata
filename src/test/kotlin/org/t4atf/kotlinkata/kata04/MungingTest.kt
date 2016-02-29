package org.t4atf.kotlinkata.kata04

import org.assertj.core.api.Assertions
import org.junit.gen5.api.Test
import org.mockito.Mockito

class MungingTest {

    @Test fun noDays() {
        val minSpreads = munging(listOf())

        Assertions.assertThat(minSpreads).isEmpty()
    }

    @Test fun findSmallestSpread() {
        val minSpreads = munging(listOf(
                WeatherLine(1, 20.0, 10.0, 15.0),
                WeatherLine(2, 20.0, 12.0, 16.0),
                WeatherLine(3, 10.0, -2.0, 4.0),
                WeatherLine(4, 30.0, 10.0, 20.0)
        ))

        Assertions.assertThat(minSpreads).containsOnly(Pair(2, 8.0))
    }

    @Test fun multipleDaysWithSameMinimumSpread() {
        val minSpreads = munging(listOf(
                WeatherLine(1, 20.0, 12.0, 16.0),
                WeatherLine(2, 22.0, 14.0, 18.0),
                WeatherLine(3, 10.0, -2.0, 4.0),
                WeatherLine(4, 30.0, 10.0, 20.0)
        ))

        Assertions.assertThat(minSpreads).containsOnly(Pair(2, 8.0), Pair(1, 8.0))
    }

    @Test fun print() {
        val out = Mockito.spy(System.out)
        print(munging, listOf(
                WeatherLine(1, 20.0, 12.0, 16.0),
                WeatherLine(2, 22.0, 14.0, 18.0),
                WeatherLine(3, 10.0, -2.0, 4.0),
                WeatherLine(4, 30.0, 10.0, 20.0)
        ), out)

        Mockito.verify(out).println("Minimal spread of 8.0 found in day 1")
        Mockito.verify(out).println("Minimal spread of 8.0 found in day 2")
    }
}