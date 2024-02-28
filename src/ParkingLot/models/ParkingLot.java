package ParkingLot.models;

import ParkingLot.models.enums.ParkingLotStatus;
import ParkingLot.models.enums.VehicleType;
import ParkingLot.services.billCalculationStrategy.BillCalculationStrategy;
import ParkingLot.services.spotAllocationStrategy.SpotAllocationStrategy;

import java.util.List;

public class ParkingLot {
    private String name;
    private String address;
    private int capacity;
    private List<ParkingFloor> parkingFloorList;
    private List<VehicleType> supportedVehicleTypeList;
    private ParkingLotStatus parkingLotStatus;
    private BillCalculationStrategy billCalculationStrategy;
    private SpotAllocationStrategy spotAllocationStrategy;

    public ParkingLot(){
    }

    public ParkingLot(String name, String address, int capacity, List<ParkingFloor> parkingFloorList, List<VehicleType> supportedVehicleTypeList, ParkingLotStatus parkingLotStatus, BillCalculationStrategy billCalculationStrategy, SpotAllocationStrategy spotAllocationStrategy) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.parkingFloorList = parkingFloorList;
        this.supportedVehicleTypeList = supportedVehicleTypeList;
        this.parkingLotStatus = parkingLotStatus;
        this.billCalculationStrategy = billCalculationStrategy;
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public List<VehicleType> getSupportedVehicleTypeList() {
        return supportedVehicleTypeList;
    }

    public void setSupportedVehicleTypeList(List<VehicleType> supportedVehicleTypeList) {
        this.supportedVehicleTypeList = supportedVehicleTypeList;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public BillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }

    public void setBillCalculationStrategy(BillCalculationStrategy billCalculationStrategy) {
        this.billCalculationStrategy = billCalculationStrategy;
    }

    public SpotAllocationStrategy getSpotAllocationStrategy() {
        return spotAllocationStrategy;
    }

    public void setSpotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }
}
