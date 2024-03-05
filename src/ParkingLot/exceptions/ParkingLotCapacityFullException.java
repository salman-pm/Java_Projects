package ParkingLot.exceptions;

public class ParkingLotCapacityFullException extends RuntimeException{
    public ParkingLotCapacityFullException() {
    }

    public ParkingLotCapacityFullException(String message) {
        super(message);
    }

    public ParkingLotCapacityFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingLotCapacityFullException(Throwable cause) {
        super(cause);
    }

    public ParkingLotCapacityFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
