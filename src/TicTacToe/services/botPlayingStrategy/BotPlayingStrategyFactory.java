package TicTacToe.services.botPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(){
        return new EasyBotPlayingStrategy();
    }
}
