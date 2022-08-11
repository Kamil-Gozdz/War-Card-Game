package war.game;

import java.util.*;

public class Game {
    public static void main(String[] args) {
        Player player1 = null;
        Player player2 =null;
        int choice;
        GameFunctions gameFunctions =new GameFunctions();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------------------------");
        System.out.println("| Welcome to the battleground of card game called \"WAR\" |");
        System.out.println("---------------------------------------------------------");
        System.out.println();


        do {
            System.out.println("Please choose number of players: ");
            System.out.println("[1] player    [2] players");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Player 1 write your name: ");
                    String name1 = scanner.next();
                    player1 = new Player(name1);
                    break;
                case 2:
                    System.out.println("Player 1 write your name: ");
                    name1 = scanner.next();
                    player1 = new Player(name1);
                    System.out.println("Player 2 write your name: ");
                    String name2 = scanner.next();
                    player2 = new Player(name2);
                    break;
                default:
                    System.out.println("Choose correct number");
            }
        } while (choice != 1 && choice != 2);
        System.out.println("------------------------");
        System.out.println("Let's start the battle!");
        System.out.println("*************************");
        System.out.println("Creating a new deck...");
        System.out.println();
        ArrayList<Card> deck = gameFunctions.createDeck();
        System.out.println("Shuffling the deck....");
        System.out.println();
        gameFunctions.shuffleDeck(deck);
        Deque<Card> playerCards = gameFunctions.cardsForPlayer(deck);
        Deque<Card> compCards = gameFunctions.cardsForComp(deck);
        gameFunctions.cardPlaying(playerCards,compCards,player1);




    }
}
