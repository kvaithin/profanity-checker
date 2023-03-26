package com.kvaithin.profanity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

internal class ProfanityCheckerTest {

    @Test
    fun testSearchProfanityListForText() {
        val profanityList = ProfanityChecker.searchProfanityListForText("arseshit")
        assertEquals(1, profanityList.size)
        assertEquals("en", profanityList.first().language)
    }

    @Test
    fun testSearchProfanityListForCanonicalForm1() {
        val profanityList = ProfanityChecker.searchProfanityListForCanonicalForm1("arse")
        assertEquals(17, profanityList.size)
        assertEquals("en", profanityList.first().language)
    }

    @Test
    fun testSearchProfanityListForCanonicalForm2() {
        val profanityList = ProfanityChecker.searchProfanityListForCanonicalForm2("arse")
        assertEquals(6, profanityList.size)
        assertEquals("en", profanityList.first().language)
    }

    @Test
    fun testSearchProfanityListForCanonicalForm3() {
        val profanityList = ProfanityChecker.searchProfanityListForCanonicalForm3("ass")
        assertEquals(2, profanityList.size)
        assertEquals("en", profanityList.first().language)
    }

    @Test
    fun testSearchProfanityListForCategory1() {
        val profanityList = ProfanityChecker.searchProfanityListForCategory1("sexual anatomy / sexual acts")
        assertEquals(980, profanityList.size)
        assertEquals("en", profanityList.first().language)
    }

    @Test
    fun testSearchProfanityListForCategory2() {
        val profanityList = ProfanityChecker.searchProfanityListForCategory2("bodily fluids / excrement")
        assertEquals(61, profanityList.size)
        assertEquals("en", profanityList.first().language)
    }

    @Test
    fun testSearchProfanityListForCategory3() {
        val profanityList = ProfanityChecker.searchProfanityListForCategory3("animal references")
        assertEquals(1, profanityList.size)
        assertEquals("en", profanityList.first().language)
    }

    @Test
    fun testSearchProfanityListForAtLeastSeverityRatingOf() {
        val profanityList = ProfanityChecker.searchProfanityListForAtLeastSeverityRatingOf(3.0)
        assertEquals(164, profanityList.size)
        assertEquals("en", profanityList.first().language)
    }

    @Test
    fun testSearchProfanityListForSeverityDescription() {
        val profanityList = ProfanityChecker.searchProfanityListForSeverityDescription("Strong")
        assertEquals(713, profanityList.size)
        assertEquals("en", profanityList.first().language)
    }

    @Test
    fun testTextHasProfanity() {
        assertTrue(ProfanityChecker.textHasProfanity("1fuck1"))
        assertFalse(ProfanityChecker.textHasProfanity("Hello world"))
    }
}