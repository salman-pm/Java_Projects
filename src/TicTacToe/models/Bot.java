package TicTacToe.models;

import TicTacToe.services.botPlayingStrategy.BotPlayingStrategy;
import TicTacToe.services.botPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, "BOT", PlayerType.BOT, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        return BotPlayingStrategyFactory.getBotPlayingStrategy().makeMOve(board, this);
    }
}
