package com.ternaryop.crashreporter.reporter

import android.content.Context
import com.ternaryop.crashreporter.Reporter
import com.ternaryop.photoshelf.util.notification.notify

class NotificationReporter(protected val context: Context) : Reporter {
    override fun report(t: Throwable) {
        t.notify(context, "Application died")
    }
}