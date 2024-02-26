package TicTacToe.services.winningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOfOneWinningStrategy implements WinningStrategy{
    private int dimension;
    private List<HashMap<Character, Integer>> rowCountHashMapList;
    private List<HashMap<Character, Integer>> columnCountHashMapList;
    private HashMap<Character, Integer> leftDiagnolCountHashMap;
    private HashMap<Character, Integer> rightDiagnolCountHashMap;
    private HashMap<Character, Integer> cornerCountHashMap;
    public OrderOfOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        rowCountHashMapList = new ArrayList<>();
        columnCountHashMapList = new ArrayList<>();
        leftDiagnolCountHashMap = new HashMap<>();
        rightDiagnolCountHashMap = new HashMap<>();
        cornerCountHashMap = new HashMap<>();
        for(int i=0; i<dimension; i++){
            rowCountHashMapList.add(new HashMap<>());
            columnCountHashMapList.add(new HashMap<>());
        }
    }
    @Override
    public void handleUndo(Board board, Move move) {
        Cell lastPlayedCell = move.getCell();
        int row =  lastPlayedCell.getRow();
        int col = lastPlayedCell.getColumn();
        char symbol = move.getPlayer().getSymbol();
        //get the HashMaps of row and column from their list
        HashMap<Character, Integer> rowHM = rowCountHashMapList.get(row);
        HashMap<Character, Integer> colHM = columnCountHashMapList.get(col);
        //update HashMap of the row
        rowHM.put(symbol, rowHM.get(symbol) - 1);
        //update the HashMap of column
        colHM.put(symbol, colHM.get(symbol) - 1);
        //check and update HashMap of left diagonal
        if(checkIfCellIsInLeftDiagnolOrNot(row, col)){
            leftDiagnolCountHashMap.put(symbol, leftDiagnolCountHashMap.get(symbol) - 1);
        }
        //check and update HashMap of right diagonal
        if(checkIfCellIsInRightDiagnolOrNot(row, col)){
            rightDiagnolCountHashMap.put(symbol, rightDiagnolCountHashMap.get(symbol) - 1);
        }
        //check and update corner cell
        if(checkIfCellIsCornerOrNot(row, col)){
            cornerCountHashMap.put(symbol, cornerCountHashMap.get(symbol) - 1);
        }
    }
    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getColumn();

        boolean isWinner = ( checkIfCellIsCornerOrNot(row, col) && checkAndUpdateCorners(symbol) )
                || checkAndUpdateRow(row, symbol)
                || checkAndUpdateColumn(col, symbol)
                || ( checkIfCellIsInLeftDiagnolOrNot(row, col) && checkAndUpdateLeftDiagnol(symbol) )
                || ( checkIfCellIsInRightDiagnolOrNot(row, col) && checkAndUpdateRightDiagnol(symbol) );

        if(isWinner){
            return player;
        }
        return null;
    }

    private boolean checkIfCellIsCornerOrNot(int row, int col){
        return (row == 0 && col == 0) || (row == 0 && col == dimension - 1)
                || (row == dimension - 1 && col == 0) || (row == dimension - 1 && col == dimension - 1);
    }
    private boolean checkIfCellIsInLeftDiagnolOrNot(int row, int col){
        return row == col;
    }
    private boolean checkIfCellIsInRightDiagnolOrNot(int row, int col){
        return ((row + col) == (dimension-1));
    }

    private boolean checkAndUpdateCorners(char symbol){
        int oldVal = cornerCountHashMap.getOrDefault(symbol, 0);
        cornerCountHashMap.put(symbol, oldVal+1);
        return cornerCountHashMap.get(symbol) == 4;
    }
    private boolean commonWinnerCheckAndUpdate(char symbol, HashMap<Character, Integer> map){
        int oldVal = map.getOrDefault(symbol,0);
        map.put(symbol, oldVal+1);
        return map.get(symbol) == dimension;
    }
    private boolean checkAndUpdateRow(int row, char symbol){
        HashMap<Character, Integer> currentRowHashMap = rowCountHashMapList.get(row);
        return commonWinnerCheckAndUpdate(symbol, currentRowHashMap);
    }
    private boolean checkAndUpdateColumn(int col, char symbol){
        HashMap<Character, Integer> currentColHashMap = columnCountHashMapList.get(col);
        return commonWinnerCheckAndUpdate(symbol, currentColHashMap);
    }
    private boolean checkAndUpdateLeftDiagnol(char symbol){
        return commonWinnerCheckAndUpdate(symbol, leftDiagnolCountHashMap);
    }
    private boolean checkAndUpdateRightDiagnol(char symbol){
        return commonWinnerCheckAndUpdate(symbol, rightDiagnolCountHashMap);
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<HashMap<Character, Integer>> getRowCountHashMapList() {
        return rowCountHashMapList;
    }

    public void setRowCountHashMapList(List<HashMap<Character, Integer>> rowCountHashMapList) {
        this.rowCountHashMapList = rowCountHashMapList;
    }

    public List<HashMap<Character, Integer>> getColumnCountHashMapList() {
        return columnCountHashMapList;
    }

    public void setColumnCountHashMapList(List<HashMap<Character, Integer>> columnCountHashMapList) {
        this.columnCountHashMapList = columnCountHashMapList;
    }

    public HashMap<Character, Integer> getLeftDiagnolCountHashMap() {
        return leftDiagnolCountHashMap;
    }

    public void setLeftDiagnolCountHashMap(HashMap<Character, Integer> leftDiagnolCountHashMap) {
        this.leftDiagnolCountHashMap = leftDiagnolCountHashMap;
    }

    public HashMap<Character, Integer> getRightDiagnolCountHashMap() {
        return rightDiagnolCountHashMap;
    }

    public void setRightDiagnolCountHashMap(HashMap<Character, Integer> rightDiagnolCountHashMap) {
        this.rightDiagnolCountHashMap = rightDiagnolCountHashMap;
    }

    public HashMap<Character, Integer> getCornerCountHashMap() {
        return cornerCountHashMap;
    }

    public void setCornerCountHashMap(HashMap<Character, Integer> cornerCountHashMap) {
        this.cornerCountHashMap = cornerCountHashMap;
    }
}
