package ParkingLot.exceptions;

public class NoSpaceAvailableException extends RuntimeException{
    public NoSpaceAvailableException() {
    }

    public NoSpaceAvailableException(String message) {
        super(message);
    }

    public NoSpaceAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSpaceAvailableException(Throwable cause) {
        super(cause);
    }

    public NoSpaceAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
