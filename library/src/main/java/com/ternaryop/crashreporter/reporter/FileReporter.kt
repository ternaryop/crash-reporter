package com.ternaryop.crashreporter.reporter

import android.content.Context
import android.os.Environment
import com.ternaryop.crashreporter.Reporter
import com.ternaryop.utils.log.Log
import java.io.File

class FileReporter(context: Context) : Reporter {
    val baseDir = context.getExternalFilesDir(null) ?: Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    override fun report(t: Throwable) {
        val file = File(File(baseDir, "crash"), "crash_report.txt")
        Log.error(t, file)
    }
}