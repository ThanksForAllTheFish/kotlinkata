package org.t4atf.kotlinkata.kata04

import org.assertj.core.api.Assertions
import org.junit.gen5.api.Test
import org.mockito.Mockito

class FootballTest {

    @Test fun testLoad() {
        val lines = load<FootballLine>("kata04/football.dat")
                .invoke(footballSelector, footballDomainMapper)

        Assertions.assertThat(lines).containsExactly(
                FootballLine("Arsenal", 79, 36),
                FootballLine("Liverpool", 67, 30),
                FootballLine("Leicester", 30, 64)
        )
    }

    @Test fun noDays() {
        val minSpreads = footballMunging(listOf())

        Assertions.assertThat(minSpreads).isEmpty()
    }

    @Test fun findSmallestSpread() {
        val minSpreads = footballMunging(listOf(
                FootballLine("Arsenal", 79, 36),
                FootballLine("Liverpool", 67, 30),
                FootballLine("Leicester", 30, 64)
        ))

        Assertions.assertThat(minSpreads).containsOnly(Pair("Leicester", -34))
    }

    @Test fun multipleDaysWithSameMinimumSpread() {
        val minSpreads = footballMunging(listOf(
                FootballLine("Arsenal", 79, 78),
                FootballLine("Liverpool", 67, 68),
                FootballLine("Leicester", 30, 64)
        ))

        Assertions.assertThat(minSpreads).containsOnly(Pair("Arsenal", 1), Pair("Liverpool", -1))
    }

    @Test fun print() {
        val out = Mockito.spy(System.out)
        print(listOf(
                Pair("Arsenal", 1),
                Pair("Liverpool", -1)
        ), out, footballOutFormatter)

        Mockito.verify(out).println("Minimal difference is 1 for Arsenal")
        Mockito.verify(out).println("Minimal difference is -1 for Liverpool")
    }
}
