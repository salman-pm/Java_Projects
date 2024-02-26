package TicTacToe.services.winningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
    void handleUndo(Board board, Move move);

}
