package TicTacToe.services.botPlayingStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public interface BotPlayingStrategy {
    Move makeMOve(Board board, Player player);
}
