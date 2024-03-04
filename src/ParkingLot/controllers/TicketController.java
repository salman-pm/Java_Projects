package ParkingLot.controllers;

import ParkingLot.exceptions.InvalidUserRequestException;
import ParkingLot.models.ParkingLot;
import ParkingLot.models.Ticket;
import ParkingLot.models.Vehicle;
import ParkingLot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public Ticket generateTicket(Vehicle vehicle, int parkingLotID, int gateID){
        //validate user inputs
        if(parkingLotID <=0 || gateID <= 0){
            throw new InvalidUserRequestException("Please enter valid details");
        }
        return ticketService.generateTicket(vehicle, parkingLotID, gateID);
    }
}
