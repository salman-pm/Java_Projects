package ParkingLot.models;

import ParkingLot.models.enums.BillStatus;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bill extends BaseModel{
    private LocalDateTime exitTime;
    private double amount;
    private BillStatus billStatus;
    private Ticket ticket;
    private Gate exitGate;

    public Bill(){
    }

    public Bill(LocalDateTime exitTime, double amount, BillStatus billStatus, Ticket ticket, Gate exitGate) {
        this.exitTime = exitTime;
        this.amount = amount;
        this.billStatus = billStatus;
        this.ticket = ticket;
        this.exitGate = exitGate;
    }

    @Override
    public String toString() {
        return "{" +
                " \n Exit Time: " + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(exitTime) +
                ", \n Amount: Rs." + amount +
                ", \n Bill Status: " + billStatus +
                ", \n Ticket Id: " + ticket.getId() +
                ", \n ExitGate Number: " + exitGate.getGateNumber() +
                "\n }";
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
}
