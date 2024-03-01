package ParkingLot.models;

import ParkingLot.models.enums.ParkingSpotStatus;
import ParkingLot.models.enums.VehicleType;

public class LuxuryParkingSpot extends ParkingSpot{
    private Employee guard;

    public LuxuryParkingSpot() {
    }

    public LuxuryParkingSpot(int spotNumber, VehicleType vehicleType, Vehicle vehicle, ParkingSpotStatus parkingSpotStatus, Employee guard) {
        super(spotNumber, vehicleType, vehicle, parkingSpotStatus);
        this.guard = guard;
    }

    public Employee getGuard() {
        return guard;
    }

    public void setGuard(Employee guard) {
        this.guard = guard;
    }
}
