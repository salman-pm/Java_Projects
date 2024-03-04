package ParkingLot.exceptions;

public class InvalidUserRequestException extends RuntimeException{
    public InvalidUserRequestException(String message) {
        super(message);
    }

    public InvalidUserRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserRequestException(Throwable cause) {
        super(cause);
    }

    public InvalidUserRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
