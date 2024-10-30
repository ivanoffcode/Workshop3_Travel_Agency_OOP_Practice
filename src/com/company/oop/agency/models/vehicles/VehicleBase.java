package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public abstract class VehicleBase implements Vehicle {
    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.10;
    public static final double PRICE_MAX_VALUE = 2.50;

    private static final String PASSENGER_ERROR_MESSAGE = String.format("A vehicle with " +
            "less than %d passenger" +
            " or more than %d passengers cannot exist!", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final String PRICE_ERROR_MESSAGE = String.format ("A vehicle with a " +
            "price per kilometer lower than " +
            "$%.2f or higher than $%.2f cannot exist!", PRICE_MIN_VALUE, PRICE_MAX_VALUE);

    private int id;
    private int passengerCapacity;
    private double pricePerKilometer;

    public VehicleBase(int id, int passengerCapacity, double pricePerKilometer) {
        setId(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }

    private void setId(int id) {
        this.id = id;
    }

    protected void validatePassengerCapacity(int passengerCapacity) {
        validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                PASSENGER_ERROR_MESSAGE
        );
    }

    protected void validatePricePerKilometer(double pricePerKilometer) {
        validateValueInRange(
                pricePerKilometer,
                PRICE_MIN_VALUE,
                PRICE_MAX_VALUE,
                PRICE_ERROR_MESSAGE
        );
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public abstract VehicleType getType();

    @Override
    public String getAsString() {
        return String.format(
                "Passenger capacity: %d\n" +
                        "Price per kilometer: %.2f\n" +
                        "Vehicle type: %s\n",
                getPassengerCapacity(), getPricePerKilometer(), getType());
    }
}
