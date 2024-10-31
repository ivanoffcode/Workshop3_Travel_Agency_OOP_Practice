package com.company.oop.agency.core.contracts;

import com.company.oop.agency.models.JourneyImpl;
import com.company.oop.agency.models.TicketImpl;
import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.AirplaneImpl;
import com.company.oop.agency.models.vehicles.BusImpl;
import com.company.oop.agency.models.vehicles.TrainImpl;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import java.util.List;

public interface AgencyRepository {

    List<TicketImpl> getTickets();

    List<Vehicle> getVehicles();

    List<JourneyImpl> getJourneys();

    <T extends Identifiable> T findElementById(List<T> elements, int id);

    BusImpl createBus(int passengerCapacity, double pricePerKilometer);

    TicketImpl createTicket(Journey journey, double costs);

    TrainImpl createTrain(int passengerCapacity, double pricePerKilometer, int carts);

    AirplaneImpl createAirplane(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood);

    JourneyImpl createJourney(String startLocation, String destination, int distance, Vehicle vehicle);

}