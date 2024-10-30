package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import static com.company.oop.agency.utils.ValidationHelper.validateStringLength;
import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public class JourneyImpl implements Journey {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;

    private static final String START_LOCATION_ERROR_MESSAGE = String.format("The StartingLocation's length " +
            "cannot be less than %d or more than " +
            "%d symbols long.", START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH);
    private static final String DESTINATION_ERROR_MESSAGE = String.format("The Destination's length " +
            "cannot be less than %d or more than " +
            "%d symbols long.", DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH);
    private static final String DISTANCE_ERROR_MESSAGE = String.format("The Distance " +
            "cannot be less than %d or more than " +
            "%d kilometers.", DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE);


    int id;
    private String startLocation;
    private String destination;
    private int distance;
    private Vehicle vehicle;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        setId(id);
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        setVehicle(vehicle);
    }


    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double calculateTravelCosts() {
        return getDistance() * getVehicle().getPricePerKilometer();
    }

    @Override
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setStartLocation(String startLocation) {
        validateStringLength(startLocation, START_LOCATION_MIN_LENGTH,
                START_LOCATION_MAX_LENGTH, START_LOCATION_ERROR_MESSAGE);
        this.startLocation = startLocation;
    }

    private void setDestination(String destination) {
        validateStringLength(destination, DESTINATION_MIN_LENGTH,
                DESTINATION_MAX_LENGTH, DESTINATION_ERROR_MESSAGE);
        this.destination = destination;
    }

    private void setDistance(int distance) {
        validateValueInRange(distance, DISTANCE_MIN_VALUE,
                DISTANCE_MAX_VALUE, DISTANCE_ERROR_MESSAGE);
        this.distance = distance;
    }

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getAsString() {
        return String.format("Journey ----\n" +
                "Start location: %s\n" +
                "Destination: %s\n" +
                "Distance: %d\n" +
                "Vehicle type: %s\n" +
                "Travel costs: %.2f\n", getStartLocation(), getDestination(),
                getDistance(), getVehicle().getType(), calculateTravelCosts()) ;
    }
}