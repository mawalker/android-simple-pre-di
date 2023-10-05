package com.example.testsimplepredi.first.samplerepo


import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

class ClassUsingSampleRepoTest {

    // class being mocked
    private val sampleRepo: SampleRepo = mockk(relaxed = true)

    // class being tested
    private lateinit var classBeingTested: ClassUsingSampleRepo

    @Test
    fun testGetConfig() {

        val testString = "secret_string"

        // GIVEN
        every { sampleRepo.getConfig() } returns testString
        initClassBeingTested()

        // THEN
        assertEquals(testString, sampleRepo.getConfig())

    }

    private fun initClassBeingTested() {
        classBeingTested = ClassUsingSampleRepo(sampleRepo)
    }
}