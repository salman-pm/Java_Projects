package ParkingLot.repository;

import ParkingLot.exceptions.BillNotFoundException;
import ParkingLot.models.Bill;

import java.util.HashMap;

public class BillRepository {
    private HashMap<Integer, Bill> billMap;
    private static int idCounter = 0;

    public BillRepository(){
        this.billMap = new HashMap<>();
    }

    public Bill get(int billId){
        Bill bill = billMap.get(billId);
        if(bill == null){
            throw new BillNotFoundException("There is no bill with id " + billId);
        }
        return bill;
    }

    public void put(Bill bill){
        bill.setId(++idCounter);
        billMap.put(bill.getId(), bill);
        System.out.println("Bill with id " + bill.getId() + " has been added successfully");
    }
}
