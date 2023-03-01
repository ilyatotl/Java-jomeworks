import Games.Game;
import customers.Developer;
import customers.Journalist;
import customers.Player;
import management.Observer;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class GameConsole {
    Observer observer;
    List<Game> games;

    public GameConsole() {
        observer = new Observer();
        games = new ArrayList<>();

        observer.addUser(new Player("Bob"));
        observer.addUser(new Player("Alex"));

        observer.addUser(new Developer("Sam"));
        observer.addUser(new Developer("Tom"));

        observer.addUser(new Journalist("Alice"));
    }

    public void newGame(Game game) {
        games.add(game);
        observer.announce(game);
    }
}
