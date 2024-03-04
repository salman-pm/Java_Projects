package ParkingLot.models;

import ParkingLot.models.enums.ParkingLotStatus;
import ParkingLot.models.enums.VehicleType;
import ParkingLot.services.billCalculationStrategy.BillCalculationStrategy;
import ParkingLot.services.spotAllocationStrategy.SpotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private int availableCapacity;
    private int totalCapacity;
    private List<ParkingFloor> parkingFloorList;
    private List<VehicleType> supportedVehicleTypeList;
    private ParkingLotStatus parkingLotStatus;
    private BillCalculationStrategy billCalculationStrategy;
    private SpotAllocationStrategy spotAllocationStrategy;

    public ParkingLot(){
    }

    public ParkingLot(String name, String address, int availableCapacity, int totalCapacity,
                      List<ParkingFloor> parkingFloorList, List<VehicleType> supportedVehicleTypeList,
                      ParkingLotStatus parkingLotStatus, BillCalculationStrategy billCalculationStrategy,
                      SpotAllocationStrategy spotAllocationStrategy) {
        this.name = name;
        this.address = address;
        this.availableCapacity = availableCapacity;
        this.totalCapacity = totalCapacity;
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

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
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
