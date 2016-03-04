package org.t4atf.kotlinkata.kata04

import java.nio.file.Paths
import java.util.*

fun <T> load(location: String) =
    fun(selector: (String) -> Boolean, domainMapper: (String) -> T) =  extractLines(location)
            .filter(selector)
            .map(domainMapper)

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
