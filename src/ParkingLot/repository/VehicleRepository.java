package ParkingLot.repository;

import ParkingLot.exceptions.VehicleNotFoundException;
import ParkingLot.models.Vehicle;

import java.util.HashMap;

public class VehicleRepository {
    private HashMap<Integer, Vehicle> vehicleMap;
    private static int idCounter = 0; //auto-generated id value

    public VehicleRepository(){
        this.vehicleMap = new HashMap<>();
    }

    public Vehicle get(int vehicleId){
        Vehicle vehicle = vehicleMap.get(vehicleId);
        if(vehicle == null){
            throw new VehicleNotFoundException("There is no vehicle with id " + vehicleId);
        }
        return vehicle;
    }

    public void add(Vehicle vehicle){
        vehicle.setId(++idCounter);
        vehicleMap.put(vehicle.getId(), vehicle);
        System.out.println("Vehicle with id " + vehicle.getId() + " has been added successfully");
    }
}
