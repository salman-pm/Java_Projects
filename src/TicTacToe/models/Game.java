package TicTacToe.models;

import TicTacToe.exceptions.*;
import TicTacToe.services.winningStrategy.OrderOfOneWinningStrategy;
import TicTacToe.services.winningStrategy.WinningStrategy;
import TicTacToe.services.winningStrategy.WinningStrategyFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private List<Board> boardStates;
    private GameStatus gameStatus;
    private WinningStrategy winningStrategy;
    private Player winner;
    private Player currentPlayer;
    private int noOfSymbols;

    public Game(Board board, List<Player> players, WinningStrategy winningStrategy) {
        this.board = board;
        this.players = players;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winningStrategy = winningStrategy;
        this.winner = null;
        this.currentPlayer = null;
        this.noOfSymbols = players.size();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getNoOfSymbols() {
        return noOfSymbols;
    }

    public void setNoOfSymbols(int noOfSymbols) {
        this.noOfSymbols = noOfSymbols;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private Board board;
        private List<Player> players;
        private WinningStrategy winningStrategy;
        private int dimension;

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public void validateNumberOfPlayers(){
            //if no bot -> playerSize = N-1  |  if there is a bot -> playerSize = N-2
            if(players.size() < dimension-2 || players.size() > dimension-1){
                throw new InvalidNumerOfPlayersException("No of players should be N-1 or N-2 where N is board size");
            }
        }

        public void validateBotCount(){
            long noOfBots = players.stream()
                                   .filter(player -> player.getPlayerType().equals(PlayerType.BOT))
                                   .count();
            if(noOfBots > 1){
                throw  new InvalidBotCountException("Maximum of 1 Bot is allowed in a game");
            }
        }

        public void validateSymbols(){
            Set<Character> symbolsSet = new HashSet<>();
            for(Player player : players){
                if(player.getSymbol() == ' '){
                    throw new InvalidSymbolException("Symbol cannot be empty");
                }
                symbolsSet.add(player.getSymbol());
            }
//            symbolsSet = players.stream()
//                    .map(Player::getSymbol)
//                    .collect(Collectors.toSet());
            if(symbolsSet.size() != players.size()){
                throw new InvalidNumberOfSymbolsException("Each player should have distinct symbol");
            }
        }

        public void validateDimension(){
            if(dimension<3 || dimension>10){
                throw new InvalidBoardSizeException("Board size should be between 3 and 10");
            }
        }

        public void validate(){
            validateNumberOfPlayers();
            validateSymbols();
            validateBotCount();
            validateDimension();
        }

        public Game build(){
            validate();
            return new Game(new Board(dimension), players, winningStrategy);
        }

    }

    public void undo(){
        if(moves.isEmpty()){
            System.out.println("There is no moves to undo");
            return;
        }
        //remove the last played move from list
        int lastPlayedMoveIndex = moves.size() - 1;
        Move lastPlayedMove = moves.remove(lastPlayedMoveIndex);

        //update the cell
        Cell lastPlayedCell = lastPlayedMove.getCell();
        lastPlayedCell.setPlayer(null);
        lastPlayedCell.setCellState(CellState.EMPTY);

        //remove the last board state from list
        int lastBoardIndex = boardStates.size() - 1;
        Board lastBoardState = boardStates.remove(lastBoardIndex);

        //update the counts in hashmaps in WinningStrategy
        winningStrategy.handleUndo(lastBoardState, lastPlayedMove);
    }

    public boolean checkDraw(){
        if(winningStrategy.getClass() != OrderOfOneWinningStrategy.class){
            int noOfMoves = moves.size();
            int totalNoOfCells = board.getDimension() * board.getDimension();
            return noOfMoves ==  totalNoOfCells;
        }

        OrderOfOneWinningStrategy orderOfOneWinningStrategy = OrderOfOneWinningStrategy.getInstance(board.getDimension());
//        return orderOfOneWinningStrategy.getSetOfHashMaps().isEmpty();
        return orderOfOneWinningStrategy.checkDraw();
    }
}
