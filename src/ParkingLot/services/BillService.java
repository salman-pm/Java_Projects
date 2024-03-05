package ParkingLot.services;

import ParkingLot.models.*;
import ParkingLot.models.enums.BillStatus;
import ParkingLot.models.enums.ParkingLotStatus;
import ParkingLot.models.enums.ParkingSpotStatus;
import ParkingLot.models.enums.VehicleType;
import ParkingLot.repository.*;
import ParkingLot.services.billCalculationStrategy.BillCalculationStrategy;
import ParkingLot.services.billCalculationStrategy.BillCalculationStrategyFactory;

import java.time.LocalDateTime;

public class BillService {
    private BillRepository billRepository;
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingLotRepository parkingLotRepository;

    public BillService(BillRepository billRepository, GateRepository gateRepository, TicketRepository ticketRepository, ParkingSpotRepository parkingSpotRepository, ParkingLotRepository parkingLotRepository) {
        this.billRepository = billRepository;
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Bill generateBill(int parkingLotId, int ticketId, int exitGateId){
        Ticket ticket = ticketRepository.get(ticketId);
        Gate exitGate = gateRepository.get(exitGateId);
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);

        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        BillCalculationStrategy billCalculationStrategy = BillCalculationStrategyFactory.getBillCalculationStrategy(vehicleType);

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

        //release the parking spot and update the capacity
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSpotRepository.update(parkingSpot);
        //update the capacity of parking lot and update the status if it's full
        parkingLot.setAvailableCapacity(parkingLot.getAvailableCapacity() + 1);
        if(parkingLot.getParkingLotStatus().equals(ParkingLotStatus.FULL) && parkingLot.getAvailableCapacity() > 0){
            parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        }
        parkingLotRepository.update(parkingLot);

        //id will be generate after put() in repository. So, get the bill from repository and return it
        return billRepository.get(bill.getId());
    }
}
