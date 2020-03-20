package com.shubhobrataroy.bongoproblems1to3.problem2.solutionB;

public class PlaneSolutionB extends VehicleSolutionB {

    private int carWheelCount;
    private int carPassengerCount;
    private float gasLeft = 0f;

    protected PlaneSolutionB() {
        this.carWheelCount = 3;
        this.carPassengerCount = 50;
        this.gasLeft = 100f;
    }

    @Override
    public int getTotalWheels() {
        return 0;
    }

    @Override
    protected void setTotalWheels(int totalWheels) {
        this.carWheelCount = totalWheels;
    }

    @Override
    public int getTotalPassengers() {
        return carPassengerCount;
    }

    @Override
    protected void setTotalPassengers(int totalPassengers) {
        this.carPassengerCount = totalPassengers;
    }

    @Override
    public boolean isHasGasLeft() {
        return gasLeft <= 0;
    }

    @Override
    protected void setGas(float gas) {
        this.gasLeft = gas;
    }

}
