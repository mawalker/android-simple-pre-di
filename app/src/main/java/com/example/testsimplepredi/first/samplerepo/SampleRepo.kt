package com.example.testsimplepredi.first.samplerepo

class SampleRepo {

    private lateinit var _config: String

    private constructor(config: String) {
        _config = config
    }

    fun getConfig(): String {
        return _config
    }

    private constructor()


    /**
     * Builder class for SampleRepo
     */
    class Builder {
        private var _builderConfig = "Default Config"

        fun setConfig(config: String) {
            _builderConfig = config
        }

        fun build(): SampleRepo {
            return SampleRepo(_builderConfig)
        }


    }
}
