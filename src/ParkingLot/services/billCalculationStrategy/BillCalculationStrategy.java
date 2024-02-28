package ParkingLot.services.billCalculationStrategy;

import ParkingLot.models.Bill;
import ParkingLot.models.Ticket;

public interface BillCalculationStrategy {
    Bill generateBill(Ticket ticket);
}
