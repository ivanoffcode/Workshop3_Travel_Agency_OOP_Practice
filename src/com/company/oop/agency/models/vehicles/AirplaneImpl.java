package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.contracts.Train;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public class AirplaneImpl extends VehicleBase implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.10;
    public static final double PRICE_MAX_VALUE = 2.50;

    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer);
        setHasFreeFood(hasFreeFood);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                String.format(PASSENGER_ERROR_MESSAGE,
                        Airplane.class.getSimpleName().toLowerCase(),
                        PASSENGER_MIN_VALUE,
                        PASSENGER_MAX_VALUE));
    }

    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        validateValueInRange(
                pricePerKilometer,
                PRICE_MIN_VALUE,
                PRICE_MAX_VALUE,
                String.format(PRICE_ERROR_MESSAGE,
                        Airplane.class.getSimpleName().toLowerCase(),
                        PRICE_MIN_VALUE,
                        PRICE_MAX_VALUE));
    }

    public boolean getHasFreeFood() {
        return hasFreeFood;
    }

    private void setHasFreeFood(boolean hasFreeFood) {
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    public boolean hasFreeFood() {
        return getHasFreeFood();
    }

    @Override
    public VehicleType getType() {
        return VehicleType.AIR;
    }

    @Override
    public String getAsString() {
        return "Airplane ----\n" + super.getAsString() + String.format("Has free food: %s\n", getHasFreeFood());
    }
}