package ParkingLot.services.surgeCalculationStrategy;

import ParkingLot.models.ParkingLot;

public class SimpleSurgeCalculationStrategy implements SurgeCalculationStrategy{
    @Override
    public double calculateSurge(ParkingLot parkingLot) {
        int noOfFilledSpots = parkingLot.getTotalCapacity() - parkingLot.getAvailableCapacity();
        double percentageOfSpotsAvailable = ((double) noOfFilledSpots / parkingLot.getTotalCapacity()) * 100;
        if(percentageOfSpotsAvailable > 90){
            return 0.9;
        }
        else if(percentageOfSpotsAvailable > 75){
            return 0.75;
        }
        else if(percentageOfSpotsAvailable > 60){
            return 0.6;
        }
        else{
            return 0;
        }
    }
}
