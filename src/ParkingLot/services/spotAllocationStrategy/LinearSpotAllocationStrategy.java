package ParkingLot.services.spotAllocationStrategy;

import ParkingLot.exceptions.ParkingSpotNotFoundForVehicleException;
import ParkingLot.models.ParkingFloor;
import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Vehicle;
import ParkingLot.models.enums.ParkingFloorStatus;
import ParkingLot.models.enums.ParkingSpotStatus;

import java.util.List;

public class LinearSpotAllocationStrategy implements SpotAllocationStrategy{

    private boolean validateParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle){
        if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY) &&
                        parkingSpot.getVehicleType().equals(vehicle.getVehicleType())
        ){
            return true;
        }
        return false;
    }

    private boolean validateParkingFloor(ParkingFloor parkingFloor){
        if(parkingFloor.getParkingFloorStatus().equals(ParkingFloorStatus.AVAILABLE)){
            return true;
        }
        return false;
    }

    @Override
    public ParkingSpot allocateSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        //iterate through each parking spots in each floor(linear iteration) and find the empty spot
        for(ParkingFloor parkingFloor : parkingLot.getParkingFloorList()){
            if(validateParkingFloor(parkingFloor)){
                for(ParkingSpot parkingSpot : parkingFloor.getParkingSpotList()){
                    int floorNo = parkingSpot.getSpotNumber() / 100;
                    if(validateParkingSpot(parkingSpot, vehicle)){
                        return parkingSpot;
                    }
                }
            }
        }
        throw new ParkingSpotNotFoundForVehicleException("There is no parking spot found for this vehicle");
    }

}
