package ParkingLot.repository;

import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.exceptions.TicketNotFoundException;
import ParkingLot.models.Gate;
import ParkingLot.models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    private HashMap<Integer, Ticket> ticketMap;
    private static int idCounter = 0;

    public TicketRepository(){
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketId){
        Ticket ticket = ticketMap.get(ticketId);
        if(ticket == null){
            throw new TicketNotFoundException("There is no ticket with id " + ticketId);
        }
        return ticket;
    }

    public void put(Ticket ticket){
        ticket.setId(++idCounter);
        ticketMap.put(ticket.getId(), ticket);
        System.out.println("Ticket with id " + ticket.getId() + " has been added successfully");
    }
}
