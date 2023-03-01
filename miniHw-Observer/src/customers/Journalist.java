package customers;

import Games.Game;

public class Journalist extends User {
    public Journalist(String name) {
        super(name);
    }

    @Override
    public String announce(Game game) {
        return "Journalist: " + name +
               ". Game: " + game.getTitle() +
               ". Info: " + game.getInfo();
    }
}
