package ParkingLot.services.surgeCalculationStrategy;

import ParkingLot.models.enums.VehicleType;

public class SurgeCalculationStrategyFactory {
    public static SurgeCalculationStrategy getSurgeCalculationFactory(VehicleType vehicleType){
        return new SimpleSurgeCalculationStrategy();
    }
}
