package ParkingLot;

import ParkingLot.controllers.InitializationController;
import ParkingLot.repository.GateRepository;
import ParkingLot.repository.ParkingFloorRepository;
import ParkingLot.repository.ParkingLotRepository;
import ParkingLot.repository.ParkingSpotRepository;
import ParkingLot.services.InitializationService;

public class ParkingLotClient {
    public static void main(String[] args) {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        GateRepository gateRepository = new GateRepository();

        InitializationService initializationService = new InitializationService(parkingLotRepository, parkingFloorRepository,
                                                                                parkingSpotRepository, gateRepository);

        InitializationController initializationController = new InitializationController(initializationService);

        initializationController.init();
        System.out.println("END");
    }
}
