package org.t4atf.kotlinkata.kata04

import java.io.PrintStream
import java.nio.file.Paths
import java.util.*

fun <T> load(location: String) =
    fun(selector: (String) -> Boolean, domainMapper: (String) -> T) = extractLines(location)
            .filter(selector)
            .map(domainMapper)

fun <L, R> print(pairs: List<Pair<L, R>>, out: PrintStream, stringFormatter: (L, R) -> String) {
    for ((left, right) in pairs) {
        out.println(stringFormatter.invoke(left, right))
    }
}

fun <T, L, R : Comparable<R>> munging(teams: List<T>, grouper: (T) -> R, mapper: (T) -> Pair<L, R>) = teams
        .groupBy(grouper)
        .toSortedMap()
        .map { entry -> entry.value }
        .firstOrNull()
        ?.map(mapper)
        .orEmpty()

fun isNumber(input : String) : Boolean {
    try {
        input.toDouble()
        return true
    } catch (e : NumberFormatException) {
        return false
    }
}

private fun extractLines(location: String): MutableList<String> {
    val lines = listOf<String>().toMutableList()
    Scanner(Paths.get(ClassLoader.getSystemResource(location).toURI())).use {
        val scanner = it.useDelimiter(System.lineSeparator())
        while (scanner.hasNext()) {
            lines.add(scanner.next())
        }
    }
    return lines
}