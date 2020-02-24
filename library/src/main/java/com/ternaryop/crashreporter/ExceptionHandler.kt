package com.ternaryop.crashreporter

import kotlin.system.exitProcess

private const val LOG_TAG = "CrashReport"

class ExceptionHandler(private val originalHandler: Thread.UncaughtExceptionHandler?) : Thread.UncaughtExceptionHandler {
    private val list: MutableList<Reporter> = mutableListOf()

    fun add(reporter: Reporter) {
        list.add(reporter)
    }

    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        android.util.Log.w(LOG_TAG, "Catched exception " + throwable.message)

        list.forEach { it.report(throwable) }

        if (originalHandler == null) {
            exitProcess(1)
        } else {
            originalHandler.uncaughtException(thread, throwable)
        }
    }
}