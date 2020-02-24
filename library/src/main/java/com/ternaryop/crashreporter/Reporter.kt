package com.ternaryop.crashreporter

interface Reporter {
    fun report(t: Throwable)
}