package com.ternaryop.crashreporter.reporter

import com.ternaryop.crashreporter.Reporter

/**
 * Show a notification passing the exception to the [notifier]
 */
class NotificationReporter(private val notifier : (t: Throwable) -> Unit) : Reporter {
    override fun report(t: Throwable) {
        notifier(t)
    }
}