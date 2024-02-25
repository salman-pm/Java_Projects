package TicTacToe.models;

import TicTacToe.exceptions.*;
import TicTacToe.services.winningStrategy.WinningStrategy;

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
//            int botCount = 0;
//            for(Player player : players){
//                if(player.getPlayerType().equals(PlayerType.BOT)){
//                    botCount++;
//                }
//                if(botCount > 1){
//                    throw  new InvalidBotCountException("Maximum of 1 Bot is allowed in a game");
//                }
//            }
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

        public void validateDimenstion(){
            if(dimension<3 || dimension>10){
                throw new InvalidBoardSizeException("Board size should be between 3 and 10");
            }
        }

        public void validate(){
            validateNumberOfPlayers();
            validateSymbols();
            validateBotCount();
        }

        public Game build(){
            validate();
            return new Game(new Board(dimension), players, winningStrategy);
        }

    }
}
