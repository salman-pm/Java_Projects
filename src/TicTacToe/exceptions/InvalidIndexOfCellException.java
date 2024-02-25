package TicTacToe.exceptions;

public class InvalidIndexOfCellException extends RuntimeException{
    public InvalidIndexOfCellException() {
    }

    public InvalidIndexOfCellException(String message) {
        super(message);
    }

    public InvalidIndexOfCellException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIndexOfCellException(Throwable cause) {
        super(cause);
    }

    public InvalidIndexOfCellException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
