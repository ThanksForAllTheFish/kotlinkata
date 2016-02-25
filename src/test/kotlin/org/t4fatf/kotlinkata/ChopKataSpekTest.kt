package org.t4fatf.kotlinkata

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.t4atf.kotlinkata.ChopKata

class ChopKataSpekTest: Spek() {
    init {
        given("the ordered array of even numbers [0, 10000] and the iterative implementation of a binary search algorithm") {
            val algorithm = ChopKata()
            val source = IntRange(0, 10000)
                    .filter { n -> n % 2 == 0 }
                    .toTypedArray()
            on("the value 10") {
                var index = 5
                it("should return the index $index") {
                    Assertions.assertThat(algorithm.binarySearch(10, source)).isEqualTo(index)
                }
            }
            on("the value 3") {
                var index = -1
                it("should return the index $index") {
                    Assertions.assertThat(algorithm.binarySearch(3, source)).isEqualTo(index)
                }
            }
            on("the value 11000") {
                var index = -1
                it("should return the index $index") {
                    Assertions.assertThat(algorithm.binarySearch(11000, source)).isEqualTo(index)
                }
            }
            on("the value 10000") {
                var index = 5000
                it("should return the index $index") {
                    Assertions.assertThat(algorithm.binarySearch(10000, source)).isEqualTo(index)
                }
            }
            on("the value 0") {
                var index = 0
                it("should return the index $index") {
                    Assertions.assertThat(algorithm.binarySearch(0, source)).isEqualTo(index)
                }
            }
            on("the value -10") {
                var index = -1
                it("should return the index $index") {
                    Assertions.assertThat(algorithm.binarySearch(-10, source)).isEqualTo(index)
                }
            }
        }
    }
}

