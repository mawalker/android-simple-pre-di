package com.example.testsimplepredi.application

import android.app.Application
import com.example.testsimplepredi.BuildConfig
import com.example.testsimplepredi.core.arch.ApplicationResourceProvider
import com.example.testsimplepredi.core.arch.ApplicationResourceProviderInterface
import com.example.testsimplepredi.core.arch.logging.CrashReportingTree
import com.example.testsimplepredi.core.arch.logging.InfoUpTree
import timber.log.Timber
import timber.log.Timber.DebugTree

class ApplicationClass : Application() {

    private lateinit var applicationResourceProvider: ApplicationResourceProviderInterface

    override fun onCreate() {
        super.onCreate()

        setupLogging()
        setupGlobalSingletons()
    }

    private fun setupLogging() {
        if (BuildConfig.BUILD_TYPE.lowercase() == "debug") {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(InfoUpTree())
            Timber.plant(CrashReportingTree())
        }
    }

    private fun setupGlobalSingletons() {
        applicationResourceProvider = ApplicationResourceProvider.getInstance(this)

    }

}
