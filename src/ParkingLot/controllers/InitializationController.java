package ParkingLot.controllers;

import ParkingLot.models.ParkingLot;
import ParkingLot.services.InitializationService;

public class InitializationController {
    private InitializationService initializationService;

    public InitializationController(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    public ParkingLot init(){
        return initializationService.init();
    }
}
