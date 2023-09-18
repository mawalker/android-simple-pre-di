package com.example.testsimplepredi.core.arch

import android.app.Application
import com.example.testsimplepredi.core.arch.utils.SingletonHolder

class ApplicationResourceProvider() :
    ApplicationResourceProviderInterface {

    /**
     * Singleton Implementation methods.
     */

    constructor(application: Application) : this() {
        // This isn't double lock synchronized, but should be fine for now, might want to test further
        if (contextIsSet) {
            return
        } else {
            app = application
            contextIsSet = true
        }
    }

    companion object :
        SingletonHolder<ApplicationResourceProvider, Application>(::ApplicationResourceProvider) {
        private lateinit var app: Application
        private var contextIsSet: Boolean = false
    }

    /**
     * Interface Implementation
     */

    override fun getString(resId: Int): String {
        return app.getString(resId)
    }

}