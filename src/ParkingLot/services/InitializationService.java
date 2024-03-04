package ParkingLot.services;

import ParkingLot.models.*;
import ParkingLot.models.enums.*;
import ParkingLot.repository.GateRepository;
import ParkingLot.repository.ParkingFloorRepository;
import ParkingLot.repository.ParkingLotRepository;
import ParkingLot.repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitializationService {

    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private GateRepository gateRepository;

    public InitializationService(ParkingLotRepository parkingLotRepository,
                                 ParkingFloorRepository parkingFloorRepository,
                                 ParkingSpotRepository parkingSpotRepository,
                                 GateRepository gateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.gateRepository = gateRepository;
    }

    public ParkingLot init(){
        //Create a Parking lot object and initialize it's attributes
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("ABC Parking Lot");
        parkingLot.setAddress("Somewhere under the sky");
        parkingLot.setTotalCapacity(100);
        parkingLot.setAvailableCapacity(100);
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setSupportedVehicleTypeList(List.of(VehicleType.BIKE, VehicleType.CAR));

        //run a loop and create list of floors - Eg:parking lot will have 10 floors
        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        for(int i=1; i<=10; i++){
            //create individual parking floor object
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNUmber(i); //floor no from 1 to 10
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.AVAILABLE);

            //for each floor, create a list of parking spots - each floor will have 10 spots
            List<ParkingSpot> parkingSpotList = new ArrayList<>();
            for(int j=1; j<=10; j++){
                //create individual parking spot objects
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId((i*10) + j);
                //parking spot number ranges from 101 to 110, 201 to 210, etc. depending upon the floor number
                parkingSpot.setSpotNumber((i*100) + j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                parkingSpot.setVehicleType(VehicleType.CAR);
                //add each parking spots into the list
                parkingSpotList.add(parkingSpot);
                //save each parking spot into repository
                parkingSpotRepository.put(parkingSpot);
            }
            //add the list of parking spots into parking floor
            parkingFloor.setParkingSpotList(parkingSpotList);

            //create operator for entryGate
            Employee entryOperator = new Employee();
            entryOperator.setName(i + "A");
            entryOperator.setPhoneNo("9876543210");
            entryOperator.setAddress("Nehru street, Chennai");
            entryOperator.setEmailId(entryOperator.getName() + "@gmail.com");
            entryOperator.setDesignation(DesignationType.OPERATOR);
            //Create entry gate for each floor
            //entry gate number will be 101, 201, 301 depending on floor number
            Gate entryGate = new Gate();
            entryGate.setId((i*10) + 1);
            entryGate.setGateNumber((i*100) + 1);
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperator(entryOperator);
            //add the entry gate into parking floor and also save it in repository
            parkingFloor.setEntryGate(entryGate);
            gateRepository.put(entryGate);

            //create operator for exitGate
            Employee exitOperator = new Employee();
            exitOperator.setName(i + "B");
            entryOperator.setPhoneNo("0123456789");
            exitOperator.setAddress("Gandhi street, Chennai");
            exitOperator.setEmailId(exitOperator.getName() + "@gmail.com");
            exitOperator.setDesignation(DesignationType.OPERATOR);
            //Create exit gate for each floor
            //exit gate number will be 102, 202, 302 depending on floor number
            Gate exitGate = new Gate();
            exitGate.setId((i*10) + 2);
            exitGate.setGateNumber((i*100) + 2);
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setGateType(GateType.ENTRY);
            exitGate.setOperator(entryOperator);
            //add the exit gate into parking floor and also save it in repository
            parkingFloor.setExitGate(exitGate);
            gateRepository.put(exitGate);

            //add the individual parking floor object into parkingFloorList & save the floor in repository
            parkingFloorList.add(parkingFloor);
            parkingFloorRepository.put(parkingFloor);
        }
        //add the list of floors into parking lot object & save the list of floors in parking lot repository
        parkingLot.setParkingFloorList(parkingFloorList);
        parkingLotRepository.put(parkingLot);

        return parkingLot;
    }
}
