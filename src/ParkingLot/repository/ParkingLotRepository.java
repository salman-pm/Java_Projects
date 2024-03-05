package ParkingLot.repository;

import ParkingLot.exceptions.ParkingLotNotFoundException;
import ParkingLot.models.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepository {
    private HashMap<Integer, ParkingLot> parkingLotMap;
    private static int idCounter = 0; //for auto-generating id value

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId){
        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("There is no parking lot with id " + parkingLotId);
        }
        return parkingLot;
    }

    public void put(ParkingLot parkingLot){
        parkingLot.setId(++idCounter);
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        System.out.println("Parking Lot with id " + parkingLot.getId() + " has been added successfully");
    }

    public void update(ParkingLot parkingLot){
        parkingLotMap.put(parkingLot.getId(), parkingLot);
    }
}
