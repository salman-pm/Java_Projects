package ParkingLot.models;

import ParkingLot.models.enums.PaymentMode;
import ParkingLot.models.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Payment extends BaseModel{
    private double amount;
    private String transactionReferenceNumber;
    private Bill bill;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentTime;

    public Payment(){
    }

    public Payment(double amount, String transactionReferenceNumber, Bill bill, PaymentMode paymentMode, PaymentStatus paymentStatus, LocalDateTime paymentTime) {
        this.amount = amount;
        this.transactionReferenceNumber = transactionReferenceNumber;
        this.bill = bill;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionReferenceNumber() {
        return transactionReferenceNumber;
    }

    public void setTransactionReferenceNumber(String transactionReferenceNumber) {
        this.transactionReferenceNumber = transactionReferenceNumber;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
}
