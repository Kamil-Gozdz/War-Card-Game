package war.game;

import java.util.ArrayDeque;
import java.util.Deque;

public class Player {

    private String name;
    private Deque<Card> playerCards = new ArrayDeque<>(24) ;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Deque<Card> getCards() {
        return playerCards;
    }
}