package TicTacToe.services.winningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public class OrderOfNSquareWinningStrategy implements WinningStrategy{
    private int dimension;

    public OrderOfNSquareWinningStrategy(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        return null;
    }
}
