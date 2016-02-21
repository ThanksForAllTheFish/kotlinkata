package org.t4atf.kotlinkata

class ChopKata {

    val algorithm: (Int, Array<Int>) -> Int

    constructor() : this(fun (value: Int, source: Array<Int>): Int {
            var up = source.size - 1
            var down = 0
            while (up >= down) {
                var curr = (up + down) / 2
                val elem = source[curr]
                if(elem == value) {
                    return curr
                } else if (elem < value) {
                    down = curr + 1
                } else {
                    up = curr - 1
                }
            }

            return -1
        })

    constructor(algorithm: (Int, Array<Int>) -> Int) {
        this.algorithm = algorithm
    }

    fun binarySearch(value: Int, source: Array<Int>): Int {
        return algorithm.invoke(value, source)
    }
}
