package ParkingLot.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket extends BaseModel{
    private LocalDateTime entryTime;
    private Gate entryGate;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;

    public Ticket(){

    }

    public Ticket(LocalDateTime entryTime, Gate entryGate, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.entryTime = entryTime;
        this.entryGate = entryGate;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "{" +
                " \nTicket Id: " + getId() +
                " \nEntryTime: " + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(entryTime) +
                ", \nEntryGate Number: " + entryGate.getGateNumber() +
                ", \nParkingSpot Number: " + parkingSpot.getSpotNumber() +
                ", \nVehicle Number: " + vehicle.getVehicleNumber() +
                " \n}";
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


}
