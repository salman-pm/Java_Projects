package ParkingLot.controllers;

import ParkingLot.models.Bill;
import ParkingLot.services.BillService;

public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public Bill generateBill(int ticketID, int exitGateID){
        return billService.generateBill(ticketID, exitGateID);
    }
}
