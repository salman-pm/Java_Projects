package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.models.*;
import TicTacToe.services.winningStrategy.WinningStrategy;
import TicTacToe.services.winningStrategy.WinningStrategyNames;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        int id = 1;
        List<Player> playersList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");

        System.out.println("Please enter the dimension of the board");
        int dimension = sc.nextInt();

        System.out.println("Do you want a bot in the game? Y or N");
        String botAns = sc.next();
        if(botAns.equalsIgnoreCase("Y")){
            Player bot = new Bot(id++, '$', BotDifficultyLevel.MEDIUM);
            playersList.add(bot);
        }
        while (id < dimension){
            System.out.println("You are Player " + id + " - Please enter your name: ");
            String playerName = sc.next();
            System.out.println("You are Player " + id + " - Please enter your symbol: ");
            char symbol = sc.next().charAt(0);
            Player newPlayer = new Player(id++, playerName, PlayerType.HUMAN, symbol);
            playersList.add(newPlayer);
        }

        Collections.shuffle(playersList);
        Game game = gameController.createGame(dimension, playersList, WinningStrategyNames.ORDEROFONE);
        int currentPlayerIndex = -1;
        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            System.out.println("Current Board Status : ");
            gameController.displayBoard(game);
            //undo logic
            if(currentPlayerIndex != -1){
                Player lastMovedPlayer = playersList.get(currentPlayerIndex);
                if(lastMovedPlayer.getPlayerType() != PlayerType.BOT){
                    System.out.println("Hey " + lastMovedPlayer.getPlayerName() + " , Do you want to undo your last move? Y or N");
                    String undoAns = sc.next();
                    if(undoAns.charAt(0) == 'Y' || undoAns.charAt(0) == 'y'){
                        int lastMovedIndex = game.getMoves().size() - 1;
                        gameController.undoMove(game, game.getMoves().get(lastMovedIndex));
                        currentPlayerIndex--; //-- so that ++ will stay at current player
                    }
                }
            }
            currentPlayerIndex++; //go to next player
            currentPlayerIndex = currentPlayerIndex % playersList.size();
            Player currentPlayer = playersList.get(currentPlayerIndex);
            Move movePlayed = gameController.executeMove(game, currentPlayer);//execute move
            if(currentPlayer.getPlayerType().equals(PlayerType.BOT)){
                System.out.println("BOT played a move");
            }
            game.getMoves().add(movePlayed); //add moves to the list
            Board currentBoard = game.getBoard().clone(); //create a copy of current board state and add to list
            game.getBoardStates().add(currentBoard); //add board states after every move to the list
            Player winner = gameController.checkWinner(game, movePlayed); //check for winner
            if(winner != null){
                System.out.println("Thank You! Match ended");
                System.out.println("WINNER is " + winner.getPlayerName());
                break;
            }
            boolean isMathDraw = gameController.checkForDraw(game); //check for draw
            if(isMathDraw){
                System.out.println("---MATCH DRAWN---");
                break;
            }
        }
        System.out.println("Final Board Status ");
        gameController.displayBoard(game);

        System.out.println("Do you want to replay of the game? Y or N");
        String replayAns = sc.next();
        if(replayAns.equalsIgnoreCase("Y")){
            gameController.replay(game);
        }
    }
}
