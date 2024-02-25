package TicTacToe.exceptions;

public class InvalidNumerOfPlayersException extends RuntimeException{
    public InvalidNumerOfPlayersException() {
    }

    public InvalidNumerOfPlayersException(String message) {
        super(message);
    }

    public InvalidNumerOfPlayersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumerOfPlayersException(Throwable cause) {
        super(cause);
    }

    public InvalidNumerOfPlayersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
