package ParkingLot.services.billCalculationStrategy;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculationStrategy(){
        return new SimpleBillCalculationStrategy();
    }
}
