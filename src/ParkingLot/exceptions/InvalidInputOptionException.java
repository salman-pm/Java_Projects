package ParkingLot.exceptions;

public class InvalidInputOptionException extends RuntimeException{
    public InvalidInputOptionException() {
    }

    public InvalidInputOptionException(String message) {
        super(message);
    }

    public InvalidInputOptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputOptionException(Throwable cause) {
        super(cause);
    }

    public InvalidInputOptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
