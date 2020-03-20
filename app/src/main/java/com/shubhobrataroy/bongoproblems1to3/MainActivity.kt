package com.shubhobrataroy.bongoproblems1to3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shubhobrataroy.bongoproblems1to3.problem1.Problem1Activity
import com.shubhobrataroy.bongoproblems1to3.problem2.Problem2Activity
import com.shubhobrataroy.bongoproblems1to3.problem3.view.Problem3VideoPlayerActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Shubhobrata Roy
 *
 * Promlem 1 is written in kotlin
 */

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_problem_1.setOnClickListener(this::onClick)
        bt_problem_2.setOnClickListener(this::onClick)
        bt_problem_3.setOnClickListener(this::onClick)
    }

    fun onClick(v: View?) {
        val launchActivityClass = when (v?.id) {
            R.id.bt_problem_1 -> Problem1Activity::class.java
            R.id.bt_problem_2 -> Problem2Activity::class.java
            else -> Problem3VideoPlayerActivity::class.java
        }
        startActivity(Intent(this, launchActivityClass))
    }
}
