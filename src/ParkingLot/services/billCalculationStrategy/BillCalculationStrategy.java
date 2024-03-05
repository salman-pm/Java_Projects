package ParkingLot.services.billCalculationStrategy;

import ParkingLot.models.Bill;
import ParkingLot.models.Gate;
import ParkingLot.models.Ticket;

public interface BillCalculationStrategy {
    double calculateBillAmount(Ticket ticket);
}
