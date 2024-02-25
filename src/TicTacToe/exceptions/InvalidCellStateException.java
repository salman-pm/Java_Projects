package TicTacToe.exceptions;

public class InvalidCellStateException extends RuntimeException{
    public InvalidCellStateException() {
    }

    public InvalidCellStateException(String message) {
        super(message);
    }

    public InvalidCellStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCellStateException(Throwable cause) {
        super(cause);
    }

    public InvalidCellStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
