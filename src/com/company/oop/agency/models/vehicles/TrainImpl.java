package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Train;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public class TrainImpl extends VehicleBase implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.10;
    public static final double PRICE_MAX_VALUE = 2.50;

    private static final String TRAIN_PASSENGER_ERROR_MESSAGE = String.format("A train cannot" +
            " have less than %d passengers" +
            " or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);

    private static final String TRAIN_CARTS_ERROR_MESSAGE = String.format("A train cannot have " +
            "less than %d cart or more " +
            "than %d carts.", CARTS_MIN_VALUE, CARTS_MAX_VALUE);

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
                TRAIN_PASSENGER_ERROR_MESSAGE
        );
    }

    private void validateCartsCapacity(int passengerCapacity) {
        validateValueInRange(
                passengerCapacity,
                CARTS_MIN_VALUE,
                CARTS_MAX_VALUE,
                TRAIN_CARTS_ERROR_MESSAGE
        );
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