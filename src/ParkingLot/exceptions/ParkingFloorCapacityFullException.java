package ParkingLot.exceptions;

public class ParkingFloorCapacityFullException extends RuntimeException{
    public ParkingFloorCapacityFullException() {
    }

    public ParkingFloorCapacityFullException(String message) {
        super(message);
    }

    public ParkingFloorCapacityFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingFloorCapacityFullException(Throwable cause) {
        super(cause);
    }

    public ParkingFloorCapacityFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
