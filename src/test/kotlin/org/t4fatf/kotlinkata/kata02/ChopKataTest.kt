package org.t4fatf.kotlinkata.kata02

import org.assertj.core.api.Assertions
import org.junit.gen5.api.Test
import org.t4atf.kotlinkata.kata02.ChopKata

class ChopKataTest {
    val source = IntRange(0,10000)
                .filter { n -> n%2==0 }
                .toTypedArray()

    @Test fun defaultIterativeImplementationTest() {
        verification(ChopKata())
    }

    @Test fun iterativeDeferredCheckedTest() {
        verification(ChopKata(ChopKata.Companion.ITERATIVE_DEFERRED))
    }

    @Test fun recursiveImplementationTest() {
        verification(ChopKata(ChopKata.Companion.RECURSIVE))
    }

    @Test fun nativeImplementationTest() {
        verification(ChopKata(ChopKata.Companion.NATIVE))
    }

    private fun verification(algorithm: ChopKata) {
        Assertions.assertThat(algorithm.binarySearch(10, source)).isEqualTo(5)
        Assertions.assertThat(algorithm.binarySearch(7, source)).isEqualTo(-5)
        Assertions.assertThat(algorithm.binarySearch(-1, source)).isEqualTo(-1)
        Assertions.assertThat(algorithm.binarySearch(9000, source)).isEqualTo(4500)
        Assertions.assertThat(algorithm.binarySearch(10000, source)).isEqualTo(5000)
        Assertions.assertThat(algorithm.binarySearch(0, source)).isEqualTo(0)
        Assertions.assertThat(algorithm.binarySearch(11000, source)).isEqualTo(-5002)
    }
}