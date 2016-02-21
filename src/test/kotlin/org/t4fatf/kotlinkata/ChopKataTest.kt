package org.t4fatf.kotlinkata

import org.assertj.core.api.Assertions
import org.junit.Test
import org.t4atf.kotlinkata.ChopKata

class ChopKataTest {
    val source = IntRange(0,10000)
                .filter { n -> n%2==0 }
                .toTypedArray()

    @Test fun defaultIterativeImplementationTest() {
        verification(ChopKata())
    }

    @Test fun recursiveImplementationTest() {
        verification(ChopKata(
                fun (value: Int, source: Array<Int>): Int {
                    return iteration(value, source, source.size-1, 0)
                }
        ))
    }

    @Test fun nativeImplementationTest() {
        verification(ChopKata(
                fun (value: Int, source: Array<Int>): Int {
                    return source.binarySearch(value)
                }
        ))
    }

    private fun iteration(value: Int, source: Array<Int>, up: Int, down: Int): Int {
        if(up < down) return -1

        val curr = (up + down) / 2
        val elem = source[curr]

        if(elem == value) return curr

        if(elem < value) return iteration(value, source, up, curr+1)

        return iteration(value, source, curr-1, down)
    }

    private fun verification(algorithm: ChopKata) {
        Assertions.assertThat(algorithm.binarySearch(10, source)).isEqualTo(5)
        Assertions.assertThat(algorithm.binarySearch(7, source)).isLessThanOrEqualTo(-1)
        Assertions.assertThat(algorithm.binarySearch(-1, source)).isLessThanOrEqualTo(-1)
        Assertions.assertThat(algorithm.binarySearch(9000, source)).isEqualTo(4500)
        Assertions.assertThat(algorithm.binarySearch(10000, source)).isEqualTo(5000)
        Assertions.assertThat(algorithm.binarySearch(0, source)).isEqualTo(0)
        Assertions.assertThat(algorithm.binarySearch(11000, source)).isLessThanOrEqualTo(-1)
    }
}

//class ChopKataTest: Spek() {
//    init {
//        given("The iterative implementation of a binary search algorithm") {
//            var algorithm = ChopKata()
//            on("an the value 10 and the ordered array [1..10000]") {
//
//                it("should return the index 9") {
//                    Assertions.assertThat {  }
//                }
//            }
//            on("an the value 0 and the ordered array [1..10000]") {
//                it("should return the index -1") {
//
//                }
//            }
//            on("an the value 879 and the ordered array [1..10000]") {
//                it("should return the index 878") {
//
//                }
//            }
//        }
//    }
//}
