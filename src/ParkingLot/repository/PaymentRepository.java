package ParkingLot.repository;

import ParkingLot.exceptions.PaymentNotFoundException;
import ParkingLot.models.Payment;

import java.util.HashMap;

public class PaymentRepository {
    private HashMap<Integer, Payment> paymentMap;
    private static int idCounter = 0;

    public PaymentRepository(){
        this.paymentMap = new HashMap<>();
    }

    public Payment get(int paymentId){
        Payment payment = paymentMap.get(paymentId);
        if(payment == null){
            throw new PaymentNotFoundException("There is no payment with id " + paymentId);
        }
        return payment;
    }

    public void add(Payment payment){
        payment.setId(++idCounter);
        paymentMap.put(payment.getId(), payment);
        System.out.println("Payment with id " + payment.getId() + " has been added successfully");
    }
}
