package ParkingLot.services.spotAllocationStrategy;

import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Vehicle;

public interface SpotAllocationStrategy {
    ParkingSpot allocateSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle);
}
