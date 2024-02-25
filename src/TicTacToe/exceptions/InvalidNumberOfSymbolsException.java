package TicTacToe.exceptions;

public class InvalidNumberOfSymbolsException extends RuntimeException{
    public InvalidNumberOfSymbolsException() {
    }

    public InvalidNumberOfSymbolsException(String message) {
        super(message);
    }

    public InvalidNumberOfSymbolsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberOfSymbolsException(Throwable cause) {
        super(cause);
    }

    public InvalidNumberOfSymbolsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
