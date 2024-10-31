package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Bus;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;
import static java.lang.String.format;

public class BusImpl extends VehicleBase implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                format(PASSENGER_ERROR_MESSAGE,
                        Bus.class.getSimpleName().toLowerCase(),
                        PASSENGER_MIN_VALUE,
                        PASSENGER_MAX_VALUE));
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