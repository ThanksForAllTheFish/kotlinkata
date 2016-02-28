package org.t4fatf.kotlinkata

import org.assertj.core.api.Assertions
import org.junit.gen5.api.Test
import org.t4atf.kotlinkata.ChopKata

class ChopKataTest {
    val source = IntRange(0,10000)
                .filter { n -> n%2==0 }
                .toTypedArray()

    @Test fun defaultIterativeImplementationTest() {
        verification(ChopKata())
    }

    @Test fun iterativeDeferredCheckedTest() {
        verification(ChopKata(ChopKata.ITERATIVE_DEFERRED))
    }

    @Test fun recursiveImplementationTest() {
        verification(ChopKata(ChopKata.RECURSIVE))
    }

    @Test fun nativeImplementationTest() {
        verification(ChopKata(ChopKata.NATIVE))
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