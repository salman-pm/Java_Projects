package ParkingLot.models;

import ParkingLot.models.enums.DesignationType;

public class Employee extends BaseModel{
    private String name;
    private String phoneNo;
    private String emailId;
    private String address;
    private DesignationType designation;

    public Employee(){
    }

    public Employee(String name, String phoneNo, String emailId, String address, DesignationType designation) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.address = address;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DesignationType getDesignation() {
        return designation;
    }

    public void setDesignation(DesignationType designation) {
        this.designation = designation;
    }
}
