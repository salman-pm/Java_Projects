package ParkingLot.services;

import ParkingLot.exceptions.NoSpaceAvailableException;
import ParkingLot.models.*;
import ParkingLot.models.enums.ParkingSpotStatus;
import ParkingLot.repository.GateRepository;
import ParkingLot.repository.ParkingLotRepository;
import ParkingLot.repository.ParkingSpotRepository;
import ParkingLot.repository.TicketRepository;
import ParkingLot.services.spotAllocationStrategy.SpotAllocationStrategy;
import ParkingLot.services.spotAllocationStrategy.SpotAllocationStrategyFactory;

import java.time.LocalDateTime;

public class TicketService {
    TicketRepository ticketRepository;
    ParkingLotRepository parkingLotRepository;
    GateRepository gateRepository;
    ParkingSpotRepository parkingSpotRepository;

    public TicketService(TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository,
                         GateRepository gateRepository, ParkingSpotRepository parkingSpotRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, int parkingLotID, int gateID){
        SpotAllocationStrategy spotAllocationStrategy = SpotAllocationStrategyFactory.getSpotAllocationStrategy();
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotID);
        Gate entryGate = gateRepository.get(gateID);

        //validate parking lot capacity
        if(parkingLot.getAvailableCapacity() <= 0){
            throw new NoSpaceAvailableException("Parking lot is FULL");
        }

        //allocate space for vehicle
        ParkingSpot allocatedSpot = spotAllocationStrategy.allocateSpotForVehicle(parkingLot, vehicle);
        //update the status of parking spot
        allocatedSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        allocatedSpot.setVehicle(vehicle);
        //update in the repository
        parkingSpotRepository.put(allocatedSpot);

        //generate ticket
        Ticket ticket = new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setVehicle(vehicle);
        ticket.setEntryGate(entryGate);
        ticket.setParkingSpot(allocatedSpot);
        //update in the ticket repository
        ticketRepository.put(ticket);
        //return the ticket after updating calling put() - will generate ticket id
        return ticketRepository.get(ticket.getId());

    }
}
