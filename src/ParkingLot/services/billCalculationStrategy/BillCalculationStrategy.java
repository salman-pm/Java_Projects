package ParkingLot.services.billCalculationStrategy;

import ParkingLot.models.Bill;
import ParkingLot.models.Gate;
import ParkingLot.models.Ticket;

public abstract class BillCalculationStrategy {
    private final double basePrice = 100;
    private final double hourlyPrice = 50;
    public abstract double calculateBillAmount(Ticket ticket);

    public double getBasePrice() {
        return basePrice;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }
}
