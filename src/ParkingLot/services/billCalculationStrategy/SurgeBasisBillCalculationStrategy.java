package ParkingLot.services.billCalculationStrategy;

import ParkingLot.models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SurgeBasisBillCalculationStrategy extends BillCalculationStrategy{
    @Override
    public double calculateBillAmount(Ticket ticket) {
        double surge = ticket.getSurgeFactor();
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long noOfHours = ChronoUnit.HOURS.between(entryTime, exitTime);
        double amount = this.getBasePrice() + (noOfHours * this.getHourlyPrice());
        double totalAmount = amount + (amount * surge);
        return totalAmount;

    }
}
