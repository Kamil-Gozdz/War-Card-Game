package war.game;

import java.util.*;

public class GameFunctions implements GameRepository {


    @Override
    public ArrayList<Card> createDeck() {
        List<String> names = Card.namesOfCards();
        List<Integer> seniority = Card.valuesOfSeniority();
        ArrayList<Card> deck = new ArrayList<>();
        while(deck.size() != 24) {
            for (int i = 0; i < 6; i++) {
                deck.add(new Card(names.get(i), seniority.get(i)));
                }
            }
        return deck;
    }

    @Override
    public void shuffleDeck(ArrayList<Card> deck) {
         Collections.shuffle(deck);
    }

    @Override
    public Deque<Card> cardsForPlayer (ArrayList<Card> deck) {
        Deque<Card> playerCards = new ArrayDeque<>();
            for (int i = 0; i < deck.size(); i++){
            playerCards.add(deck.remove(0));
            }
            return playerCards;
        }

    public Deque<Card> cardsForComp (ArrayList<Card> deck) {
            return new ArrayDeque<>(deck);
        }

    @Override
    public void battle(Deque<Card> playerCards, Deque<Card> compCards) {
        Stack<Card> stack = new Stack<>();

            while(playerCards.size() != 24 && compCards.size() != 24){
                stack.push(playerCards.removeFirst());
                System.out.println("Player 1 plays a card");
                stack.push(compCards.removeFirst());
                System.out.println("Computer plays a card");

                if (stack.get(0).getCardSeniority() == stack.get(1).getCardSeniority()) {
                    while (stack.get(stack.size() -1).getCardSeniority() == stack.get(stack.size() - 2).getCardSeniority()) {
                        System.out.println("<<<IT'S A BATTLE!>>>");
                        System.out.println("Player 1 plays a card");
                        stack.push(playerCards.removeFirst());
                        System.out.println("Computer plays a card");
                        stack.push(compCards.removeFirst());
                }
                if (stack.get(0).getCardSeniority() < stack.get(1).getCardSeniority()) {
                    System.out.println("Player1 wins the battle!");
                    playerCards.addAll(stack);
                    stack.clear();
                } else {
                    System.out.println("Computer wins the battle!");
                    compCards.addAll(stack);
                    stack.clear();
                }

            } else if (stack.get(0).getCardSeniority() > stack.get(1).getCardSeniority()) {
                System.out.println("Player 1 wins the battle!");
                playerCards.addLast(stack.get(0));
                playerCards.addLast(stack.get(1));
                stack.clear();
            } else {
                System.out.println("Computer wins the battle!");
                compCards.addLast(stack.get(1));
                compCards.addLast(stack.get(0));
                stack.clear();
                }
            }
        if(playerCards.size() == 24){
            System.out.println("Player 1 wins the GAME!");
        }else if(compCards.size() == 24){
            System.out.println("Computer wins the GAME!");
        }
    }
}

