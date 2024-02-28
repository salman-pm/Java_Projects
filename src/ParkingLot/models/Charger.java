package ParkingLot.models;

import java.time.LocalDateTime;

public class Charger extends BaseModel{
    private String model;
    private Double powerOutput;
    private Double inputVoltage;

    public Charger(){
    }

    public Charger(String model, Double powerOutput, Double inputVoltage) {
        this.model = model;
        this.powerOutput = powerOutput;
        this.inputVoltage = inputVoltage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPowerOutput() {
        return powerOutput;
    }

    public void setPowerOutput(Double powerOutput) {
        this.powerOutput = powerOutput;
    }

    public Double getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(Double inputVoltage) {
        this.inputVoltage = inputVoltage;
    }
}
