package TicTacToe.services.winningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategyNames winningStrategyName, int dimension) {
        return switch (winningStrategyName) {
            case ORDEROFONE -> OrderOfOneWinningStrategy.getInstance(dimension);
            case ORDEROFN -> new OrderOfNWinningStrategy(dimension);
            case ORDEROFNSQUARE -> new OrderOfNSquareWinningStrategy(dimension);
            default -> null;
        };
    }
}
