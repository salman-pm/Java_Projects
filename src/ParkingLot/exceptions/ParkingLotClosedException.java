package ParkingLot.exceptions;

public class ParkingLotClosedException extends RuntimeException{
    public ParkingLotClosedException() {
    }

    public ParkingLotClosedException(String message) {
        super(message);
    }

    public ParkingLotClosedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingLotClosedException(Throwable cause) {
        super(cause);
    }

    public ParkingLotClosedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
