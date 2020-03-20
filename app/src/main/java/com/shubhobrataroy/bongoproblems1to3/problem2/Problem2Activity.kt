package com.shubhobrataroy.bongoproblems1to3.problem2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shubhobrataroy.bongoproblems1to3.R
import com.shubhobrataroy.bongoproblems1to3.problem2.solutionA.CarSolutionA
import com.shubhobrataroy.bongoproblems1to3.problem2.solutionA.PlaneSolutionA
import com.shubhobrataroy.bongoproblems1to3.problem2.solutionA.Vehicle
import com.shubhobrataroy.bongoproblems1to3.problem2.solutionB.VehicleBuilder

/**
 * @author Shubhobrata Roy
 */

class Problem2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_2)

        /**
         * For case A factory design pattern is used .
         *
         * Here the plane and car objects are created without exposing the creation logic to the
         * client and refer to newly created object using a common interface Vehicle.
         *
         */

        val carSolutionA = CarSolutionA() as Vehicle
        val planeSolutionA = PlaneSolutionA() as Vehicle

        carSolutionA.set_num_of_wheels()
        carSolutionA.set_num_of_passengers()
        carSolutionA.has_gas()

        planeSolutionA.set_num_of_wheels()
        planeSolutionA.set_num_of_passengers()
        planeSolutionA.has_gas()

        /**
         * For case B I have used Builder Design pattern
         *
         * Here the VehicleBuilder is responsible for created any implementation of VehicleSolutionB interface
         * In this scenario PlaneSolutionB and CarSolutionB  classes are totally hidden by the Builder
         *
         *
         */

        val carSolutionB = VehicleBuilder()
            .setCarWheelCount(4)
            .addGas(4f)
            .setCarPassengerCount(4)
            .createCar()

        val planeSolutionB = VehicleBuilder()
            .setCarWheelCount(3)
            .addGas(100f)
            .setCarPassengerCount(100)
            .createPlane()


        val a = 0
    }
}
