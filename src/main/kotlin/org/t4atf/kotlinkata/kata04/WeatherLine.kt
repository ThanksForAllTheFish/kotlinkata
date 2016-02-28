package org.t4atf.kotlinkata.kata04

class WeatherLine(val day: Int, val maxTmp: Double, val minTmp: Double, val avgTmp: Double) {
    operator fun component1(): Int {
        return day
    }
    operator fun component2(): Double {
        return maxTmp
    }
    operator fun component3(): Double {
        return minTmp
    }
    operator fun component4(): Double {
        return avgTmp
    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as WeatherLine

        if (day != other.day) return false
        if (maxTmp != other.maxTmp) return false
        if (minTmp != other.minTmp) return false
        if (avgTmp != other.avgTmp) return false

        return true
    }

    override fun hashCode(): Int{
        var result = day
        result += 31 * result + maxTmp.hashCode()
        result += 31 * result + minTmp.hashCode()
        result += 31 * result + avgTmp.hashCode()
        return result
    }

    override fun toString(): String{
        return "WeatherLine(day=$day, maxTmp=$maxTmp, minTmp=$minTmp, avgTmp=$avgTmp)"
    }
}
