package com.ternaryop.crashreporter

object CrashReporter {
    fun addReporter(reporter: Reporter) : CrashReporter {
        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        val handler = if (defaultHandler is ExceptionHandler) {
            defaultHandler
        } else {
            ExceptionHandler(defaultHandler)
        }
        handler.add(reporter)
        Thread.setDefaultUncaughtExceptionHandler(handler)
        return this
    }
}