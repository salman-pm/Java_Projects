package TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> matix;
    private int dimension;
    /*
        Eg: dimension = 3
        [
            [_, _, _]
            [_, _, _]
            [_, _, _]
        ]
     */

    public Board(int dimension) {
        this.dimension = dimension;
        //initialize the matrix
        matix = new ArrayList<>(); //create metrix - outside list
        for(int i=0; i<dimension; i++){
            matix.add(new ArrayList<>()); //add list for each rows in matrix
            for(int j=0; j<dimension; j++){
                matix.get(i).add(new Cell(i, j)); //add cells for each index in matrix
            }
        }
    }

    public void displayBoard(){
        for(int i=0; i<dimension; i++){
            List<Cell> cells = matix.get(i);
            for(Cell cell : cells){
                cell.displayCell();
            }
            System.out.println();
        }
    }

    public Board clone(){
        Board newBoard = new Board(this.dimension);
        for (int i=0; i<this.dimension; i++){
            for(int j=0; j<this.dimension; j++){
                Cell currentBoardCell = this.getMatix().get(i).get(j);
                Cell newBoardCell = newBoard.getMatix().get(i).get(j);
                if(currentBoardCell.getCellState().equals(CellState.FILLED)){
                    newBoardCell.setPlayer(currentBoardCell.getPlayer());
                    newBoardCell.setCellState(CellState.FILLED);
                }
            }
        }
        return newBoard;
    }

    public List<Cell> getEmptyCells(){
        List<Cell> listOfEmptyCells = new ArrayList<>();
        for(int i=0; i<dimension; i++){
            List<Cell> cells = matix.get(i);
            for(Cell currentCell : cells){
                if(currentCell.getCellState().equals(CellState.EMPTY)){
                    listOfEmptyCells.add(currentCell);
                }
            }
        }
        return listOfEmptyCells;
    }

    public List<List<Cell>> getMatix() {
        return matix;
    }

    public void setMatix(List<List<Cell>> matix) {
        this.matix = matix;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
