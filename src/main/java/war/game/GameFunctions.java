package war.game;

import java.util.*;

public class GameFunctions implements GameRepository {

    Stack<Card> stack = new Stack<>();

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


    public void cardPlaying(Deque<Card> playerCards, Deque<Card> compCards, Player player1) {
        while(compCards.size() != 24 && playerCards.size() != 24){
            if((compCards.size() == 1 && compCards.getLast().getCardSeniority() == playerCards.getFirst().getCardSeniority())
                    ||(playerCards.size() == 1 && playerCards.getLast().getCardSeniority() == compCards.getFirst().getCardSeniority())){
                break;
            }
            System.out.println(player1.getName() + " plays a " + playerCards.getFirst().getName());
            stack.push(playerCards.removeFirst());
            System.out.println("Computer plays a " + compCards.getFirst().getName());
            stack.push(compCards.removeFirst());


                    if(stack.get(1).getCardSeniority() == stack.get(0).getCardSeniority()) {
                        while (stack.lastElement().getCardSeniority() == stack.get(stack.size() - 2).getCardSeniority()) {
                            System.out.println("<<<IT'S A BATTLE!>>>");
                            System.out.println(player1.getName() + " plays a " + playerCards.getFirst().getName());
                            stack.push(playerCards.removeFirst());
                            System.out.println("Computer plays a " + compCards.getFirst().getName());
                            stack.push(compCards.removeFirst());

            }
            if(stack.lastElement().getCardSeniority() > stack.get(stack.size() - 2).getCardSeniority()){
                System.out.println("Computer wins the battle!");
                compCards.addAll(stack);
                stack.clear();
                }else{
                System.out.println(player1.getName() + " wins the battle!");
                playerCards.addAll(stack);
                stack.clear();
            }
        }               else if (stack.lastElement().getCardSeniority() > stack.get(stack.size() -2).getCardSeniority()) {
                            System.out.println("Computer wins the battle!");
                            compCards.addLast(stack.get(1));
                            compCards.addLast(stack.get(0));
                            stack.clear();
                                }else if (stack.lastElement().getCardSeniority() < stack.get(stack.size() - 2).getCardSeniority()) {
                                    System.out.println(player1.getName() + " wins the battle!");
                                    playerCards.addLast(stack.get(1));
                                    playerCards.addLast(stack.get(0));
                                    stack.clear();
                                }
                             }
        if(compCards.size() == 24 && playerCards.size() != 24){
            System.out.println("Computer wins the GAME!");
        }else{
            System.out.println(player1.getName() +" wins the GAME!");
        }
    }
}


