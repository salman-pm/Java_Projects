package ParkingLot.models;

import ParkingLot.models.enums.VehicleType;

public class Vehicle extends BaseModel{
    private String vehicleModel;
    private int vehicleNumber;
    private VehicleType vehicleType;
    private String color;

    public Vehicle(){
    }

    public Vehicle(String vehicleModel, int vehicleNumber, VehicleType vehicleType, String color) {
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
