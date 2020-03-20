package com.shubhobrataroy.bongoproblems1to3

import com.shubhobrataroy.bongoproblem.AnagramsEvaluator
import org.junit.Assert.fail
import org.junit.Test

class AnagramsEvaluatorTest {


    @Test
    fun checkIsAnagramCase1() {
        val anagramsEvaluator = AnagramsEvaluator()
        val isAnagramCase1 = anagramsEvaluator.checkIsAnagram("bleat", "table")
        if (!isAnagramCase1) fail("Case 1 gave wrong result")
    }

    @Test
    fun checkIsAnagramCase2() {
        val anagramsEvaluator = AnagramsEvaluator()
        val isAnagramCase2 = anagramsEvaluator.checkIsAnagram("eat", "tar")
        if (isAnagramCase2) fail("Case 2 gave wrong result")
    }


}