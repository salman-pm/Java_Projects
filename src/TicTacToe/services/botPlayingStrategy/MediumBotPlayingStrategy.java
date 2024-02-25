package TicTacToe.services.botPlayingStrategy;

import TicTacToe.models.*;

import java.util.List;
import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMOve(Board board, Player player) {
        //list to store empty cells of the current board
        List<Cell> emptyCells = board.getEmptyCells();
        //choose a random index within the range of list size
        Random random = new Random();
        int randomNumber = random.nextInt(emptyCells.size());
        Cell targetCell = emptyCells.get(randomNumber);
        //make a move to the targetCell
        targetCell.setCellState(CellState.FILLED);
        targetCell.setPlayer(player);
        return new Move(targetCell, player);
    }
}
