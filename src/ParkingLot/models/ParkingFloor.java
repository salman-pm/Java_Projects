package ParkingLot.models;

import ParkingLot.models.enums.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor {
    private int floorNUmber;
    private List<ParkingSpot> parkingSpotList;
    private Gate entryGate;
    private Gate exitGate;
    private ParkingFloorStatus parkingFloorStatus;

    public ParkingFloor(){
    }

    public ParkingFloor(int floorNUmber, List<ParkingSpot> parkingSpotList, Gate entryGate, Gate exitGate, ParkingFloorStatus parkingFloorStatus) {
        this.floorNUmber = floorNUmber;
        this.parkingSpotList = parkingSpotList;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public int getFloorNUmber() {
        return floorNUmber;
    }

    public void setFloorNUmber(int floorNUmber) {
        this.floorNUmber = floorNUmber;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
