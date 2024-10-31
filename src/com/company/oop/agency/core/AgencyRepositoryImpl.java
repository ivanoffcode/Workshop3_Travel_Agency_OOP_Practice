package com.company.oop.agency.core;

import com.company.oop.agency.exceptions.ElementNotFoundException;
import com.company.oop.agency.models.JourneyImpl;
import com.company.oop.agency.models.TicketImpl;
import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.AirplaneImpl;
import com.company.oop.agency.models.vehicles.BusImpl;
import com.company.oop.agency.models.vehicles.TrainImpl;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.core.contracts.AgencyRepository;

import java.util.ArrayList;
import java.util.List;

public class AgencyRepositoryImpl implements AgencyRepository {

    private int nextId;

    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<JourneyImpl> journeys = new ArrayList<>();
    private final List<TicketImpl> tickets = new ArrayList<>();

    public AgencyRepositoryImpl() {
        nextId = 0;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public List<JourneyImpl> getJourneys() {
        return new ArrayList<>(journeys);
    }

    @Override
    public List<TicketImpl> getTickets() {
        return new ArrayList<>(tickets);
    }

    @Override
    public AirplaneImpl createAirplane(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        AirplaneImpl airplane = new AirplaneImpl(++nextId, passengerCapacity, pricePerKilometer, hasFreeFood);
        this.vehicles.add(airplane);
        return airplane;
    }

    @Override
    public BusImpl createBus(int passengerCapacity, double pricePerKilometer) {
        BusImpl bus = new BusImpl(++nextId, passengerCapacity, pricePerKilometer);
        this.vehicles.add(bus);
        return bus;
    }

    @Override
    public TrainImpl createTrain(int passengerCapacity, double pricePerKilometer, int carts) {
        TrainImpl train = new TrainImpl(++nextId, passengerCapacity, pricePerKilometer, carts);
        this.vehicles.add(train);
        return train;
    }

    @Override
    public JourneyImpl createJourney(String startLocation, String destination, int distance, Vehicle vehicle) {
        JourneyImpl journey = new JourneyImpl(++nextId, startLocation, destination, distance, vehicle);
        this.journeys.add(journey);
        return journey;
    }

    @Override
    public TicketImpl createTicket(Journey journey, double costs) {
        TicketImpl ticket = new TicketImpl(++nextId, journey, costs);
        this.tickets.add(ticket);
        return ticket;
    }

     public <T extends Identifiable> T findElementById(List<T> elements, int id) {
         for (T element : elements) {
             if (element.getId() == id) {
                 return element;
             }
         }
         throw new ElementNotFoundException(String.format("No element with ID %d", id));
    }

}