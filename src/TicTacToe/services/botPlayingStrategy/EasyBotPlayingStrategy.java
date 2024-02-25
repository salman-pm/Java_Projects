package TicTacToe.services.botPlayingStrategy;

import TicTacToe.exceptions.GameOverException;
import TicTacToe.models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMOve(Board board, Player bot) {
        List<List<Cell>> matrix = board.getMatix();
        int dimension = matrix.size();
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                Cell cell = matrix.get(i).get(j);
                if(cell.getCellState().equals(CellState.EMPTY)){
                    cell.setPlayer(bot);
                    cell.setCellState(CellState.FILLED);
                    return new Move(cell, bot);
                }
            }
        }
        throw new GameOverException("Math Draw : There are no empty cells in the board");
    }
}
