package ParkingLot.services.billCalculationStrategy;

import ParkingLot.models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
/*
  total amount = base price + (no.of hours * price per hour)
*/

public class HourlyBasisBillCalculationStrategy extends BillCalculationStrategy{
    @Override
    public double calculateBillAmount(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long noOfHours = ChronoUnit.HOURS.between(entryTime, exitTime);
        double totalAmount = this.getBasePrice() + (noOfHours * this.getHourlyPrice());
        return totalAmount;
    }
}
