package TicTacToe.controllers;

import TicTacToe.models.*;
import TicTacToe.services.winningStrategy.WinningStrategy;
import TicTacToe.services.winningStrategy.WinningStrategyFactory;
import TicTacToe.services.winningStrategy.WinningStrategyNames;

import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> players, WinningStrategyNames winningStrategyName){
        //Game will automatically start after creation
        WinningStrategy winningStrategy = WinningStrategyFactory.getWinningStrategy(winningStrategyName, dimension);
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(winningStrategy)
                .build();
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public Move executeMove(Game game, Player player){
        Board board = game.getBoard();
        return player.makeMove(board);
    }

    public Player checkWinner(Game game, Move lastPlayedMove){
        Board board = game.getBoard();
        return game.getWinningStrategy().checkWinner(board, lastPlayedMove);
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    //undo will return a state of board after that move -> save board state after each move - Doremon undo method
    public Board undoMove(Game game, Move lastPlayedMove){
        //change the state of the last played cell and remove the player from the last played cell
        lastPlayedMove.getCell().setCellState(CellState.EMPTY);
        lastPlayedMove.getCell().setPlayer(null);
        //remove the last board state and get the  previous board state(last move-1)  and return it
        //int lastPlayedIndex = game.getMoves().indexOf(lastPlayedMove);
        int lastPlayedIndex = game.getBoardStates().size()-1;
        game.getBoardStates().remove(lastPlayedIndex);
        return game.getBoardStates().get(lastPlayedIndex-1);
    }

    public void replay(Game game){
        List<Board> listOfBoards = game.getBoardStates();
        List<Move> listOfMoves = game.getMoves();
//        for(Board board : listOfBoards){
//            board.displayBoard();
//            System.out.println("------------------");
//        }
        for(int i=0; i<listOfBoards.size(); i++){
            Player player = listOfMoves.get(i).getPlayer();
            Cell movedCell = listOfMoves.get(i).getCell();
            System.out.println("Player " + player.getPlayerName() + " with Symbol " + player.getSymbol()
                    + " - moved on (" + movedCell.getRow() + " , " + movedCell.getColumn() + ")");
            listOfBoards.get(i).displayBoard();
            System.out.println("-------------------------");
            try{
                Thread.sleep(2500);
            }catch (InterruptedException ie){
                throw new RuntimeException(ie);
            }
        }
    }

    public boolean checkForDraw(Game game){
        int dimensionOfBoard = game.getBoard().getDimension();
        int noOfMoves = game.getMoves().size();
        int totalCells =  dimensionOfBoard * dimensionOfBoard;
        return noOfMoves == totalCells;
    }
}
