package com.shubhobrataroy.bongoproblems1to3.problem2.solutionB;

public class VehicleBuilder {
    private int carWheelCount = 4;
    private int carPassengerCount = 4;
    private float gasLeft = 0f;


    public VehicleBuilder setCarWheelCount(int carWheelCount) {
        this.carWheelCount = carWheelCount;
        return this;
    }

    public VehicleBuilder setCarPassengerCount(int carPassengerCount) {
        this.carPassengerCount = carPassengerCount;
        return this;
    }

    public VehicleBuilder addGas(float gasLeft) {
        this.gasLeft += gasLeft;
        return this;
    }

    public VehicleSolutionB createCar() {
        CarSolutionB carSolutionB = new CarSolutionB();
        carSolutionB.setGas(this.gasLeft);
        carSolutionB.setTotalPassengers(carPassengerCount);
        carSolutionB.setGas(gasLeft);
        return carSolutionB;
    }

    public VehicleSolutionB createPlane() {
        PlaneSolutionB planeSolutionB = new PlaneSolutionB();
        planeSolutionB.setGas(this.gasLeft);
        planeSolutionB.setTotalPassengers(carPassengerCount);
        planeSolutionB.setGas(gasLeft);
        return planeSolutionB;
    }


}
