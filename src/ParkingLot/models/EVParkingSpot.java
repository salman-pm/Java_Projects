package ParkingLot.models;

import ParkingLot.models.enums.ParkingSpotStatus;
import ParkingLot.models.enums.VehicleType;

public class EVParkingSpot extends ParkingSpot{
    private Charger charger;

    public EVParkingSpot(int spotNumber, VehicleType vehicleType, Vehicle vehicle, ParkingSpotStatus parkingSpotStatus, Charger charger) {
        super(spotNumber, vehicleType, vehicle, parkingSpotStatus);
        this.charger = charger;
    }

    public Charger getCharger() {
        return charger;
    }

    public void setCharger(Charger charger) {
        this.charger = charger;
    }
}
