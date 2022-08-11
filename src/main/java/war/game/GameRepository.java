package war.game;

import java.util.ArrayList;
import java.util.Deque;

public interface GameRepository {

  ArrayList<Card> createDeck();

 void shuffleDeck(ArrayList<Card> deck);

 Deque<Card> cardsForPlayer (ArrayList<Card> deck);
 Deque<Card> cardsForComp (ArrayList<Card> deck);


 void cardPlaying(Deque<Card> playerCards,Deque<Card> compCards,Player player1);


}
