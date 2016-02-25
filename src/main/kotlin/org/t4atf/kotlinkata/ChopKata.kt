package org.t4atf.kotlinkata

class ChopKata {

    companion object {
        val DEFAULT_ITERATIVE = fun (value: Int, source: Array<Int>): Int {
            var up = source.size - 1
            var down = 0
            while (up >= down) {
                var curr = (up + down) / 2
                val elem = source[curr]
                if (elem < value) {
                    down = curr + 1
                } else if (elem > value) {
                    up = curr - 1
                } else {
                    return curr
                }
            }

            return -1
        }

        val ITERATIVE_DEFERRED = fun (value: Int, source: Array<Int>): Int {
            var up = source.size -1
            var down = 0
            while (up > down) {
                var curr = (up + down) / 2
                val elem = source[curr]
                if (elem < value) {
                    down = curr + 1
                } else {
                    up = curr
                }
            }

            if(down == up && source[down] == value)
                return down

            return -1
        }

        val NATIVE = fun (value: Int, source: Array<Int>): Int {
            return source.binarySearch(value)
        }

        val RECURSIVE = fun (value: Int, source: Array<Int>): Int {
            return step(value, source, source.size-1, 0)
        }

        tailrec
        private fun step(value: Int, source: Array<Int>, up: Int, down: Int): Int {
            if(up < down) return -1

            val curr = (up + down) / 2
            val elem = source[curr]


            if(elem < value) return step(value, source, up, curr+1)
            if(elem > value) return step(value, source, curr-1, down)

            return curr
        }
    }

    val algorithm: (Int, Array<Int>) -> Int

    constructor() : this(DEFAULT_ITERATIVE)

    constructor(algorithm: (Int, Array<Int>) -> Int) {
        this.algorithm = algorithm
    }

    fun binarySearch(value: Int, source: Array<Int>): Int {
        return algorithm.invoke(value, source)
    }
}
