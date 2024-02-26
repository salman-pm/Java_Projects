package TicTacToe.services.winningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public class OrderOfNWinningStrategy implements WinningStrategy{
    private int dimension;

    public OrderOfNWinningStrategy(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player currentPlayer = lastMove.getPlayer();
        char symbol = currentPlayer.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getColumn();

        boolean isWinner =  checkIfCornerOrNot(row, col) && checkCornersForWinner(board, row, col, symbol)
                || checkRowForWinner(board, row, col, symbol)
                || checkColumnForWinner(board, row, col, symbol)
                || checkIfLeftDiagonalOrNot(row, col) && checkLeftDiagonalForWinner(board, row, col, symbol)
                || checkIfRightDiagonalOrNot(row, col) && checkRightDiagonalForWinner(board, row, col, symbol);

        if(isWinner){
            return currentPlayer;
        }else{
            return null;
        }
    }
    private boolean checkIfCornerOrNot(int row, int col){
        return (row == 0 && col == 0) || (row == 0 && col == dimension - 1)
                || (row == dimension - 1 && col == 0) || (row == dimension - 1 && col == dimension - 1);
    }
    private boolean checkIfLeftDiagonalOrNot(int row, int col){
        return row == col;
    }
    private boolean checkIfRightDiagonalOrNot(int row, int col){
        return ((row+col) == (dimension-1));
    }
    private boolean checkCornersForWinner(Board board, int row, int col, char targetSymbol){
        Cell topLeftCell = board.getMatix().get(0).get(0);
        Cell topRightCell = board.getMatix().get(0).get(dimension - 1);
        Cell bottomLeftCell = board.getMatix().get(dimension - 1).get(0);
        Cell bottomRightCell = board.getMatix().get(dimension - 1).get(dimension-1);
        if(topLeftCell.getPlayer() == null || topRightCell.getPlayer() == null ||
                bottomLeftCell.getPlayer() == null || bottomRightCell.getPlayer() == null)
        {
            return false;
        }
        return (topLeftCell.getPlayer().getSymbol() == targetSymbol) &&
                (topLeftCell.getPlayer().getSymbol() == topRightCell.getPlayer().getSymbol()) &&
                (topLeftCell.getPlayer().getSymbol() == bottomLeftCell.getPlayer().getSymbol()) &&
                (topLeftCell.getPlayer().getSymbol() == bottomRightCell.getPlayer().getSymbol());
    }
    private boolean checkLeftDiagonalForWinner(Board board, int row, int col, char targetSymbol){
        int totalCountOfSymbols = 0;
        int rowIndex = row, colIndex = col;
        while(rowIndex>=0 && colIndex>=0){
            Cell currentCell = board.getMatix().get(rowIndex).get(colIndex);
            char currentSymbol = ' ';
            if(currentCell.getPlayer() != null){
                currentSymbol = currentCell.getPlayer().getSymbol();
            }
            if(currentSymbol == targetSymbol)
                totalCountOfSymbols++;
            rowIndex--;
            colIndex--;
        }
        rowIndex = row+1;
        colIndex = col+1;
        while(rowIndex < dimension && colIndex < dimension){
            Cell currentCell = board.getMatix().get(rowIndex).get(colIndex);
            char currentSymbol = ' ';
            if(currentCell.getPlayer() != null){
                currentSymbol = currentCell.getPlayer().getSymbol();
            }
            if(currentSymbol == targetSymbol)
                totalCountOfSymbols++;
            rowIndex++;
            colIndex++;
        }
        return totalCountOfSymbols == dimension;
    }
    private boolean checkRightDiagonalForWinner(Board board, int row, int col, char targetSymbol){
        int totalCountOfSymbols = 0;
        int rowIndex = row, colIndex = col;
        while(rowIndex < dimension && colIndex >= 0){
            Cell currentCell = board.getMatix().get(rowIndex).get(colIndex);
            char currentSymbol = ' ';
            if(currentCell.getPlayer() != null){
                currentSymbol = currentCell.getPlayer().getSymbol();
            }
            if(currentSymbol == targetSymbol)
                totalCountOfSymbols++;
            rowIndex++;
            colIndex--;
        }
        rowIndex = row-1;
        colIndex = col+1;
        while(rowIndex >= 0 && colIndex < dimension){
            Cell currentCell = board.getMatix().get(rowIndex).get(colIndex);
            char currentSymbol = ' ';
            if(currentCell.getPlayer() != null){
                currentSymbol = currentCell.getPlayer().getSymbol();
            }
            if(currentSymbol == targetSymbol)
                totalCountOfSymbols++;
            rowIndex--;
            colIndex++;
        }
        return totalCountOfSymbols == dimension;
    }
    private boolean checkRowForWinner(Board board, int row, int col, char targetSymbol){
        int totalCountOfSymbols = 0;
        int colIndex = col;
        while(colIndex >= 0){//check from o to row
            Cell currentCell = board.getMatix().get(row).get(colIndex);
            char currentSymbol = ' ';
            if(currentCell.getPlayer() != null){
                currentSymbol = currentCell.getPlayer().getSymbol();
            }
            if(currentSymbol == targetSymbol)
                totalCountOfSymbols++;
            colIndex--;
        }
        colIndex = col+1;
        while(colIndex < dimension){ //check from row+1 to dimension-1
            Cell currentCell = board.getMatix().get(row).get(colIndex);
            char currentSymbol = ' ';
            if(currentCell.getPlayer() != null){
                currentSymbol = currentCell.getPlayer().getSymbol();
            }
            if(currentSymbol == targetSymbol)
                totalCountOfSymbols++;
            colIndex++;
        }
        return totalCountOfSymbols == dimension;
    }
    private boolean checkColumnForWinner(Board board, int row, int col, char targetSymbol){
        int totalCountOfSymbols = 0;
        int rowIndex = row;
        while(rowIndex >= 0){//check from o to row
            Cell currentCell = board.getMatix().get(rowIndex).get(col);
            char currentSymbol = ' ';
            if(currentCell.getPlayer() != null){
                currentSymbol = currentCell.getPlayer().getSymbol();
            }
            if(currentSymbol == targetSymbol)
                totalCountOfSymbols++;
            rowIndex--;
        }
        rowIndex = row+1;
        while(rowIndex < dimension){ //check from row+1 to dimension-1
            Cell currentCell = board.getMatix().get(rowIndex).get(col);
            char currentSymbol = ' ';
            if(currentCell.getPlayer() != null){
                currentSymbol = currentCell.getPlayer().getSymbol();
            }
            if(currentSymbol == targetSymbol)
                totalCountOfSymbols++;
            rowIndex++;
        }
        return totalCountOfSymbols == dimension;
    }

    @Override
    public void handleUndo(Board board, Move move) {

    }
}
