package com.company.oop.agency.commands.listing;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.JourneyImpl;


import java.util.List;

import static com.company.oop.agency.utils.ListingHelpers.elementsToString;

public class ListJourneysCommand implements Command {

    private final List<JourneyImpl> journeys;

    public ListJourneysCommand(AgencyRepository agencyRepository) {
        journeys = agencyRepository.getJourneys();
    }

    public String execute(List<String> parameters) {
        if (journeys.isEmpty()) {
            return "There are no registered journeys.";
        }
        return elementsToString(journeys);
    }

}