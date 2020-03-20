package com.shubhobrataroy.bongoproblem

import java.util.*

class AnagramsEvaluator {
    fun checkIsAnagram(value1: String, value2: String): Boolean {

        if (value1.equals(value2)) return true
        else if (value1.length != value2.length) return false

        var value1TreeSet = TreeSet(value1.toList())
        var value2TreeSet = TreeSet(value2.toList())

        return value1TreeSet == value2TreeSet
    }
}