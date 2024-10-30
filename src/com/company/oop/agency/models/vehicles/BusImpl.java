package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Bus;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public class BusImpl extends VehicleBase implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;

    private static final String PASSENGER_ERROR_MESSAGE = String.format("A bus with less than %d passenger" +
            " or more than %d passengers cannot exist!", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                PASSENGER_ERROR_MESSAGE
        );
    }

    @Override
    public VehicleType getType() {
        return VehicleType.LAND;
    }

    @Override
    public String getAsString() {
        return "Bus ----\n" + super.getAsString();
    }
}