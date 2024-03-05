package ParkingLot.services.billCalculationStrategy;

import ParkingLot.models.Bill;
import ParkingLot.models.Gate;
import ParkingLot.models.Ticket;
import ParkingLot.models.enums.BillStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/*
   charge = 2 rupee per second
*/
public class SimpleBillCalculationStrategy implements BillCalculationStrategy{
    @Override
    public double calculateBillAmount(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long totalTimeSpentInParking = ChronoUnit.SECONDS.between(entryTime, exitTime);
        long amount = totalTimeSpentInParking * 2;
        return amount;
    }
}
