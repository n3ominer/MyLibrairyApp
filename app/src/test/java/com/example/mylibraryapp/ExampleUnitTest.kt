package com.example.mylibraryapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `Test pour verifier que 2+2 egal 4`() {
        // 1.ARRANGE: Setup des données
        val a = 2
        val b = 2
        val target = 5

        // 2.ACT: Action (appel de fct)
        val result = a + b

        // 3.ASSERT: Verification "assertion"
        assertEquals(result, target)
    }

}