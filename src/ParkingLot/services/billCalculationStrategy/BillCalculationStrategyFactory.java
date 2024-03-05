package ParkingLot.services.billCalculationStrategy;

import ParkingLot.models.enums.VehicleType;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculationStrategy(VehicleType vehicleType){
        return switch (vehicleType){
            case BIKE -> new HourlyBasisBillCalculationStrategy();
            case CAR -> new SurgeBasisBillCalculationStrategy();
            default -> new SimpleBillCalculationStrategy();
        };
    }
}
