package TicTacToe.services.winningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class OrderOfOneWinningStrategy implements WinningStrategy{
    private static OrderOfOneWinningStrategy INSTANCE;
    private int dimension;
    private List<HashMap<Character, Integer>> rowCountHashMapList;
    private List<HashMap<Character, Integer>> columnCountHashMapList;
    private HashMap<Character, Integer> leftDiagnolCountHashMap;
    private HashMap<Character, Integer> rightDiagnolCountHashMap;
    private HashMap<Character, Integer> cornerCountHashMap;
    private HashSet<HashMap<Character, Integer>> setOfHashMaps;

    public static OrderOfOneWinningStrategy getInstance(int dimension){
        if(INSTANCE == null){
            synchronized (OrderOfOneWinningStrategy.class){
                if(INSTANCE == null){
                    INSTANCE = new OrderOfOneWinningStrategy(dimension);
                }
            }
        }
        return INSTANCE;
    }
    private OrderOfOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        rowCountHashMapList = new ArrayList<>();
        columnCountHashMapList = new ArrayList<>();
        leftDiagnolCountHashMap = new HashMap<>();
        rightDiagnolCountHashMap = new HashMap<>();
        cornerCountHashMap = new HashMap<>();
        //populate list with HashMaps for row and column
        for(int i=0; i<dimension; i++){
            rowCountHashMapList.add(new HashMap<>());
            columnCountHashMapList.add(new HashMap<>());
        }
        //initialize setOfHashMaps - add all the hashmaps into set
        setOfHashMaps = new HashSet<>();
        for(int i=0; i<dimension; i++){
            setOfHashMaps.add(rowCountHashMapList.get(i));
            setOfHashMaps.add(columnCountHashMapList.get(i));
        }
        setOfHashMaps.add(leftDiagnolCountHashMap);
        setOfHashMaps.add(rightDiagnolCountHashMap);
        setOfHashMaps.add(cornerCountHashMap);
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
        //Also, update the hashSet of HashMaps for undo
        //updateSetOfHashMapsForUndo();
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

        //After every move and after updating the Hashmaps, Update the HashSet of HashMaps for checkDraw() algorithm
        //if a hashmap of a row/column/diagonal/corner contains two keys - then that particular row/col/dia/corner cannot have winner
        //If all the hashmaps contains more than one key, then match draw - nobody can be a winner
        //updateSetOfHashMaps();

        if(isWinner){
            return player;
        }
        return null;
    }

    public boolean checkDraw(){
        //check row hashmaps
        for(HashMap<Character, Integer> rowMap : rowCountHashMapList){
            if(rowMap.keySet().size() <= 1){
                return false;
            }
        }
        //check row hashmaps
        for(HashMap<Character, Integer> colMap : columnCountHashMapList){
            if(colMap.keySet().size() <= 1){
                return false;
            }
        }
        //check diagonal hashmaps
        if(leftDiagnolCountHashMap.keySet().size() <= 1){
            return false;
        }
        if(rightDiagnolCountHashMap.keySet().size() <= 1){
            return false;
        }
        //check corner hashmap
        if(cornerCountHashMap.keySet().size() <= 1){
            return false;
        }
        return true;
    }

    private void updateSetOfHashMaps(){
        //check row hashmaps
        for(HashMap<Character, Integer> rowMap : rowCountHashMapList){
            if(rowMap.keySet().size() > 1){
                setOfHashMaps.remove(rowMap);
            }
        }
        //check row hashmaps
        for(HashMap<Character, Integer> colMap : columnCountHashMapList){
            if(colMap.keySet().size() > 1){
                setOfHashMaps.remove(colMap);
            }
        }
        //check diagonal hashmaps
        if(leftDiagnolCountHashMap.keySet().size() > 1){
            setOfHashMaps.remove(leftDiagnolCountHashMap);
        }
        if(rightDiagnolCountHashMap.keySet().size() > 1){
            setOfHashMaps.remove(rightDiagnolCountHashMap);
        }
        //check corner hashmap
        if(cornerCountHashMap.keySet().size() > 1){
            setOfHashMaps.remove(cornerCountHashMap);
        }
    }

    private void updateSetOfHashMapsForUndo(){
        //check row hashmaps
        for(HashMap<Character, Integer> rowMap : rowCountHashMapList){
            if(!setOfHashMaps.contains(rowMap) && rowMap.keySet().size() <= 1){
                setOfHashMaps.add(rowMap);
            }
        }
        //check row hashmaps
        for(HashMap<Character, Integer> colMap : columnCountHashMapList){
            if(!setOfHashMaps.contains(colMap) && colMap.keySet().size() <= 1){
                setOfHashMaps.add(colMap);
            }
        }
        //check diagonal hashmaps
        if(!setOfHashMaps.contains(leftDiagnolCountHashMap) && leftDiagnolCountHashMap.keySet().size() <= 1){
            setOfHashMaps.add(leftDiagnolCountHashMap);
        }
        if(!setOfHashMaps.contains(rightDiagnolCountHashMap) && rightDiagnolCountHashMap.keySet().size() <= 1){
            setOfHashMaps.add(rightDiagnolCountHashMap);
        }
        //check corner hashmap
        if(!setOfHashMaps.contains(cornerCountHashMap) && cornerCountHashMap.keySet().size() <= 1){
            setOfHashMaps.add(cornerCountHashMap);
        }
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

    public HashSet<HashMap<Character, Integer>> getSetOfHashMaps() {
        return setOfHashMaps;
    }

    public void setSetOfHashMaps(HashSet<HashMap<Character, Integer>> setOfHashMaps) {
        this.setOfHashMaps = setOfHashMaps;
    }
}
