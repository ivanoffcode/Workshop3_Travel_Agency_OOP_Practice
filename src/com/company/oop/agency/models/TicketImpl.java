package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

import static com.company.oop.agency.utils.ValidationHelper.validatePositiveDouble;

public class TicketImpl implements Ticket {
    private int id;
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double administrativeCosts) {
        setId(id);
        setJourney(journey);
        setAdministrativeCosts(administrativeCosts);
    }

    private void setAdministrativeCosts(double administrativeCosts) {
        validatePositiveDouble(administrativeCosts, "costs");
        this.administrativeCosts = administrativeCosts;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return getAdministrativeCosts() * getJourney().calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f\n", getJourney().getDestination(), calculatePrice());
    }
}
