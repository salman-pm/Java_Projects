package TicTacToe.models;

import TicTacToe.exceptions.InvalidCellStateException;
import TicTacToe.exceptions.InvalidIndexOfCellException;

import java.util.Scanner;

public class Player {
    private int id;
    private String playerName;
    private PlayerType playerType;
    private char symbol;

    public Player(){
    }

    public Player(int id, String playerName, PlayerType playerType, char symbol) {
        this.id = id;
        this.playerName = playerName;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public void validateCellIndex(int row, int col, int size){
        if(row >= size || row < 0 || col >= size || col < 0){
            throw  new InvalidIndexOfCellException("given index of cell is not within the board");
        }
    }

    public void validateCellState(int row, int col, Cell targetCell){
        if(targetCell.getCellState() == CellState.FILLED){
            throw new InvalidCellStateException("the given cell id already filled");
        }
    }

    public Move makeMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println(this.playerName + " - Please enter the row to which you want to move");
        int row = sc.nextInt();
        System.out.println(this.playerName + " - Please enter the column to which you want to move");
        int col = sc.nextInt();

        int size = board.getDimension();
        Cell targetCell = board.getMatix().get(row).get(col);

        //validate the row, col entered by users
        validateCellIndex(row, col, size);
        validateCellState(row, col, targetCell);

        //make a move
        targetCell.setPlayer(this);
        targetCell.setCellState(CellState.FILLED);

        return new Move(targetCell, this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
