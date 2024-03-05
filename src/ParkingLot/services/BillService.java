package ParkingLot.services;

import ParkingLot.models.Bill;
import ParkingLot.models.Gate;
import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Ticket;
import ParkingLot.models.enums.BillStatus;
import ParkingLot.models.enums.ParkingSpotStatus;
import ParkingLot.repository.BillRepository;
import ParkingLot.repository.GateRepository;
import ParkingLot.repository.ParkingSpotRepository;
import ParkingLot.repository.TicketRepository;
import ParkingLot.services.billCalculationStrategy.BillCalculationStrategy;
import ParkingLot.services.billCalculationStrategy.BillCalculationStrategyFactory;

import java.time.LocalDateTime;

public class BillService {
    private BillRepository billRepository;
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public BillService(BillRepository billRepository, GateRepository gateRepository, TicketRepository ticketRepository, ParkingSpotRepository parkingSpotRepository) {
        this.billRepository = billRepository;
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Bill generateBill(int ticketId, int exitGateId){
        BillCalculationStrategy billCalculationStrategy = BillCalculationStrategyFactory.getBillCalculationStrategy();
        Ticket ticket = ticketRepository.get(ticketId);
        Gate exitGate = gateRepository.get(exitGateId);

        double billAmount = billCalculationStrategy.calculateBillAmount(ticket);
        //create and update the details in Bill
        Bill bill = new Bill();
        bill.setExitTime(LocalDateTime.now());
        bill.setAmount(billAmount);
        bill.setBillStatus(BillStatus.UNPAID);
        bill.setTicket(ticket);
        bill.setExitGate(exitGate);
        //update the bill repository
        billRepository.put(bill);

        //release the parking spot
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSpotRepository.update(parkingSpot);
        //id will be generate after put() in repository. So, get the bill from repository and return it
        return billRepository.get(bill.getId());
    }
}
