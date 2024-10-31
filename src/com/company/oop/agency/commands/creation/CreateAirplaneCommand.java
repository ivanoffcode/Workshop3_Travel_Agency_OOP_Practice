package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.CommandsConstants;
import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.vehicles.contracts.Airplane;

import java.util.List;

import static com.company.oop.agency.utils.ParsingHelpers.*;
import static com.company.oop.agency.utils.ValidationHelper.validateArgumentsCount;

public class CreateAirplaneCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;

    private final AgencyRepository agencyRepository;

    private int passengerCapacity;
    private double pricePerKilometer;
    private boolean hasFreeFood;

    public CreateAirplaneCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        parseParameters(parameters);
        Airplane createdAirplane = agencyRepository.createAirplane(passengerCapacity, pricePerKilometer, hasFreeFood);
        return String.format(CommandsConstants.VEHICLE_CREATED_MESSAGE, createdAirplane.getId());
    }

    private void parseParameters(List<String> parameters) {
        passengerCapacity = tryParseInteger(parameters.get(0), "passenger capacity");
        pricePerKilometer = tryParseDouble(parameters.get(1), "price");
        hasFreeFood = tryParseBoolean(parameters.get(2), "has free food");
    }


}