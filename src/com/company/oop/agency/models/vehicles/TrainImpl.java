package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public class TrainImpl extends VehicleBase implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;

    private static final String TRAIN_ERROR_MESSAGE = "A %s cannot have " +
            "less than %d %s or more " +
            "than %d %s.";

    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer);
        setCarts(carts);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                String.format(TRAIN_ERROR_MESSAGE,
                        Train.class.getSimpleName().toLowerCase(),
                        PASSENGER_MIN_VALUE, "passengers",
                        PASSENGER_MAX_VALUE, "passengers"));
    }

    private void validateCartsCapacity(int passengerCapacity) {
        validateValueInRange(
                passengerCapacity,
                CARTS_MIN_VALUE,
                CARTS_MAX_VALUE,
                String.format(TRAIN_ERROR_MESSAGE,
                        Train.class.getSimpleName().toLowerCase(),
                        CARTS_MIN_VALUE, "cart",
                        CARTS_MAX_VALUE, "carts"));
    }

    @Override
    public int getCarts() {
        return carts;
    }

    private void setCarts(int carts) {
        validateCartsCapacity(carts);
        this.carts = carts;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.LAND;
    }

    @Override
    public String getAsString() {
        return String.format(
                "Train ----%n" +
                        "%s" +
                        "Carts amount: %d\n", super.getAsString(), getCarts());
    }
}