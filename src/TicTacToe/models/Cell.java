package TicTacToe.models;

public class Cell {
    int row;
    int column;
    Player player;
    CellState cellState;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.player = null;
        this.cellState = CellState.EMPTY;
    }

    public void displayCell(){
        if(player == null){
            System.out.print("| |" );
        }
        else{
            System.out.print("|" + this.player.getSymbol() + "|");
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
