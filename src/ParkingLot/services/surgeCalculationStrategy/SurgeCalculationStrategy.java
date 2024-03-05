package ParkingLot.services.surgeCalculationStrategy;

import ParkingLot.models.ParkingLot;

public interface SurgeCalculationStrategy {
    double calculateSurge(ParkingLot parkingLot);
}
