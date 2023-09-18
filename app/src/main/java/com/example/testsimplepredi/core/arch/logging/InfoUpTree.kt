package com.example.testsimplepredi.core.arch.logging

import android.util.Log
import timber.log.Timber

class InfoUpTree : Timber.DebugTree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }
        super.log(priority, tag, message, t)
    }
}
