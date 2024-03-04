package ParkingLot.exceptions;

public class ParkingSpotNotFoundForVehicleException extends RuntimeException{
    public ParkingSpotNotFoundForVehicleException() {
    }

    public ParkingSpotNotFoundForVehicleException(String message) {
        super(message);
    }

    public ParkingSpotNotFoundForVehicleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingSpotNotFoundForVehicleException(Throwable cause) {
        super(cause);
    }

    public ParkingSpotNotFoundForVehicleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
