import Games.Game;


public class Main {
    public static void main(String[] args) {
        GameConsole gm = new GameConsole();
        gm.newGame(new Game("Chess", "Checkmate, stalemate, win in 100 games",
                "Chess is a board logic game with chess pieces on a 64-cell board.",
                "There is no additional requirement for the device."));

        gm.newGame(new Game("Backgammon", "Win against a bot, win against a player, win in 500 games",
                "Backgammon is a board game for two players on a special board divided into two halves. The goal of the game is to bring all your chips into the house and remove them from the board before the second player does it.",
                "There is no additional requirement for the device."));
    }
}