package com.shubhobrataroy.bongoproblems1to3.problem2.solutionA;

import android.util.Log;

/**
 * Here factory design pattern is used
 * Please check com.shubhobrataroy.bongoproblems1to3.problem2.Problem2Activity for explanation
 */

public class CarSolutionA implements Vehicle {
    private int carWheelCount;
    private int carPassengerCount;
    private float gasLeft = 4f;

    @Override
    public int set_num_of_wheels() {
        carWheelCount = 4;
        Log.d("VehicleInfo", "Number of wheels is set to :" + carWheelCount);
        return carWheelCount;
    }

    @Override
    public int set_num_of_passengers() {
        carPassengerCount = 4;
        Log.d("VehicleInfo", "Number of passengers is set to :" + carPassengerCount);
        return carPassengerCount;
    }

    @Override
    public boolean has_gas() {
        return gasLeft <= 0;
    }
}
