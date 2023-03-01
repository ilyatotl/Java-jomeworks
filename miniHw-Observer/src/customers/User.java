package customers;

import Games.Game;

public abstract class User {
    protected final String name;

    public User(String name) {
        this.name = name;
    }

    public String announce(Game game) {
        return "was not implemented\n";
    }
}
