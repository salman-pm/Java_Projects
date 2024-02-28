package ParkingLot.models;

import ParkingLot.models.enums.ParkingSpotStatus;
import ParkingLot.models.enums.VehicleType;

public class ParkingSpot extends BaseModel{
    private int spotNumber;
    private VehicleType vehicleType;
    private Vehicle vehicle;
    private ParkingSpotStatus parkingSpotStatus;

    public ParkingSpot(){
    }

    public ParkingSpot(int spotNumber, VehicleType vehicleType, Vehicle vehicle, ParkingSpotStatus parkingSpotStatus) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.vehicle = vehicle;
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
}
