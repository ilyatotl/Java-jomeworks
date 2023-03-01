package management;

import Games.Game;
import customers.User;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    List<User> users;

    public Observer() {
        users = new ArrayList<>();
    }

    public void addUser(User u) {
        users.add(u);
    }

    public void announce(Game g) {
        for (User u : users) {
            System.out.println(u.announce(g));
        }
        System.out.println();
    }
}
