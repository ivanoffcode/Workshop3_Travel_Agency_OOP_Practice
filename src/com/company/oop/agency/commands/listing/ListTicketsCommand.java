package com.company.oop.agency.commands.listing;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.TicketImpl;

import java.util.List;

import static com.company.oop.agency.utils.ListingHelpers.elementsToString;

public class ListTicketsCommand implements Command {

    private final List<TicketImpl> tickets;

    public ListTicketsCommand(AgencyRepository agencyRepository) {
        tickets = agencyRepository.getTickets();
    }

    public String execute(List<String> parameters) {
        if (tickets.isEmpty()) {
            return "There are no registered tickets.";
        }
        return elementsToString(tickets);
    }

}