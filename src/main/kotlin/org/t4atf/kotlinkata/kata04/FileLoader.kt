package org.t4atf.kotlinkata.kata04

interface FileLoader<T> {
    fun load(location: String) : T
}
