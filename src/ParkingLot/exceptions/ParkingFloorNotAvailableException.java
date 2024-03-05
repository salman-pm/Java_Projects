package ParkingLot.exceptions;

public class ParkingFloorNotAvailableException extends RuntimeException{
    public ParkingFloorNotAvailableException() {
    }

    public ParkingFloorNotAvailableException(String message) {
        super(message);
    }

    public ParkingFloorNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingFloorNotAvailableException(Throwable cause) {
        super(cause);
    }

    public ParkingFloorNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
