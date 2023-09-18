package com.example.testsimplepredi.repositories

interface MainFragmentsRepoInterface {

    fun getHelloWorld(postfixName: String): String
    fun getLoremIpsum(): String
    fun getFirstFragmentName(): String
    fun getSecondFragmentName(): String
}