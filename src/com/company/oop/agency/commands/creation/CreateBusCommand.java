package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.CommandsConstants;
import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

import java.util.List;

import static com.company.oop.agency.utils.ParsingHelpers.tryParseDouble;
import static com.company.oop.agency.utils.ParsingHelpers.tryParseInteger;

public class CreateBusCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;

    private final AgencyRepository agencyRepository;

    private int passengerCapacity;
    private double pricePerKilometer;

    public CreateBusCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        parseParameters(parameters);
        Bus createdBus = agencyRepository.createBus(passengerCapacity, pricePerKilometer);
        return String.format(CommandsConstants.VEHICLE_CREATED_MESSAGE, createdBus.getId());
    }

    private void parseParameters(List<String> parameters) {
        pricePerKilometer = tryParseDouble(parameters.get(1), "price");
        passengerCapacity = tryParseInteger(parameters.get(0), "passenger capacity");
    }

}