package com.shubhobrataroy.bongoproblems1to3.problem2.solutionA;

import android.util.Log;

/**
 * Here factory design pattern is used
 * Please check com.shubhobrataroy.bongoproblems1to3.problem2.Problem2Activity for explanation
 */

public class PlaneSolutionA implements Vehicle {
    private int planeWheelCount;
    private int planePassengerCount;
    private float gasLeft = 100f;

    @Override
    public int set_num_of_wheels() {
        planeWheelCount = 3;
        Log.d("VehicleInfo", "Number of wheels is set to :" + planeWheelCount);
        return planeWheelCount;
    }

    @Override
    public int set_num_of_passengers() {
        planePassengerCount = 50;
        Log.d("VehicleInfo", "Number of passengers is set to :" + planePassengerCount);
        return planePassengerCount;
    }

    @Override
    public boolean has_gas() {
        return gasLeft <= 0;
    }
}
