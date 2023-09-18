package com.example.testsimplepredi.core.arch.logging

import android.annotation.SuppressLint
import android.util.Log
import timber.log.Timber

class CrashReportingTree : Timber.Tree() {
    @SuppressLint("LogNotTimber")
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }

        t?.let {
            // This would go to Firebase Crash Analytics, Sentry, etc.
            if (priority == Log.WARN) {
                Log.w(tag, message, t)
            }
            if (priority == Log.ERROR) {
                Log.e(tag, message, t)
            }
        }
    }
}
