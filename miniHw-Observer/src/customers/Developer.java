package customers;

import Games.Game;

public class Developer extends User {
    public Developer(String name) {
        super(name);
    }

    @Override
    public String announce(Game game) {
        return "Developer: " + name +
               ". Game: " + game.getTitle() +
               ". Technical info: " + game.getTechnicalInfo();
    }
}
