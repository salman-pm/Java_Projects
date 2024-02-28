package ParkingLot.models;

import ParkingLot.models.enums.ParkingSpotStatus;
import ParkingLot.models.enums.VehicleType;

public class LuxuryParkingSpot extends ParkingSpot{
    private Operator guard;

    public LuxuryParkingSpot() {
    }

    public LuxuryParkingSpot(int spotNumber, VehicleType vehicleType, Vehicle vehicle, ParkingSpotStatus parkingSpotStatus, Operator guard) {
        super(spotNumber, vehicleType, vehicle, parkingSpotStatus);
        this.guard = guard;
    }

    public Operator getGuard() {
        return guard;
    }

    public void setGuard(Operator guard) {
        this.guard = guard;
    }
}
