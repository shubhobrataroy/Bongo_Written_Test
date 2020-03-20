package com.shubhobrataroy.bongoproblems1to3.problem1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.shubhobrataroy.bongoproblem.AnagramsEvaluator
import com.shubhobrataroy.bongoproblems1to3.R
import kotlinx.android.synthetic.main.activity_problem_1.*

/**
 * @author Shubhobrata Roy
 * Problem 1 Bongo
 *
 * Unit test available on : com.shubhobrataroy.bongoproblem.AnagramsEvaluatorTest
 * Main Anagram logic is implemented on AnagramsEvaluator
 * **/

class Problem1Activity : AppCompatActivity() {

    val anagramsEvaluator by lazy { AnagramsEvaluator() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_1)
        bt_check.setOnClickListener(this::checkAnagrams)
    }

    fun checkAnagrams(view: View) {
        val value1 = et_string_1.text.toString()
        val value2 = et_string_2.text.toString()

        val result = anagramsEvaluator.checkIsAnagram(
            et_string_1.text.toString(),
            et_string_2.text.toString()
        )

        AlertDialog.Builder(this)
            .setPositiveButton("Ok") { dialog, which -> dialog.dismiss() }
            .setMessage(
                "$value1 and $value2 are " +
                        (if (!result) "NOT"
                        else "")
                        + " anagram"
            )
            .show()

    }
}
