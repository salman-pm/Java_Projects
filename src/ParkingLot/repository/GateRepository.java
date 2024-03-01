package ParkingLot.repository;

import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.models.Gate;

import java.util.HashMap;

public class GateRepository {
    private HashMap<Integer, Gate> gateMap;

    public GateRepository(){
        this.gateMap = new HashMap<>();
    }

    public Gate get(int gateId){
        Gate gate = gateMap.get(gateId);
        if(gate == null){
            throw new GateNotFoundException("There is no gate with id " + gateId);
        }
        return gate;
    }

    public void add(Gate gate){
        gateMap.put(gate.getId(), gate);
        System.out.println("Gate with id " + gate.getId() + " has been added successfully");
    }
}
