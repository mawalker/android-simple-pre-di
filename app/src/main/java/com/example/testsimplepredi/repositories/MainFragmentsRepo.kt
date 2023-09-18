package com.example.testsimplepredi.repositories

import com.example.testsimplepredi.R
import com.example.testsimplepredi.core.arch.ApplicationResourceProvider
import com.example.testsimplepredi.core.arch.ApplicationResourceProviderInterface

class MainFragmentsRepo(
    private val applicationResourceProvider: ApplicationResourceProviderInterface
    = ApplicationResourceProvider.getInstance()
) : MainFragmentsRepoInterface {
    override fun getHelloWorld(postfixName: String): String {
        return String.format(
            applicationResourceProvider.getString(R.string.hello_world),
            postfixName
        )
    }

    override fun getLoremIpsum(): String {
        return applicationResourceProvider.getString(R.string.lorem_ipsum)
    }

    override fun getFirstFragmentName(): String {
        return applicationResourceProvider.getString(R.string.first_fragment_label)
    }

    override fun getSecondFragmentName(): String {
        return applicationResourceProvider.getString(R.string.second_fragment_label)
    }

}