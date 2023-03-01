package customers;

import Games.Game;

import java.net.SocketTimeoutException;

public class Player extends User {
    public Player(String name) {
        super(name);
    }

    @Override
    public String announce(Game game) {
        return "Player: " + name +
               ". Game: " + game.getTitle() +
               ". Achievements: " + game.getAchievements();
    }
}
