package war.game;

import java.util.Arrays;
import java.util.List;

public class Card {

    private String name;
    private int cardSeniority;

    public Card(String name, int cardSeniority) {
        this.name = name;
        this.cardSeniority = cardSeniority;
    }

    public String getName() {
        return name;
    }

    public int getCardSeniority() {
        return cardSeniority;
    }


    public static List<String> namesOfCards(){
        return Arrays.asList("Ace","King","Queen","Jack","10","9");
    }
    public static List<Integer> valuesOfSeniority(){
        return Arrays.asList(6,5,4,3,2,1);
    }

    @Override
    public String toString() {
        return name;
    }
}

