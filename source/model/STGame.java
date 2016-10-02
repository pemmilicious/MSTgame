package model;
import java.util.Scanner;
import java.util.*;

public class STGame {
    private static final int NUM_CARDS_TO_DEAL = 8;
    private int numPlayers;
    private int chosenDealer;;
    public Object randomCard;
    public ArrayList<Card> cards = STDeck.createDeck();
    public ArrayList<Card> playersHand = new ArrayList<>();
    private HashMap<Object, Object> shuffledCards;

    public STGame(int numPlayers) {
        this.numPlayers = numPlayers;

    }

    public int getDealer() {
        int chosenDealer;
        chosenDealer = 1 + (int) (Math.random() * numPlayers);
        System.out.println(chosenDealer);
        return chosenDealer;
    }


    //Shuffle Cards then deal them into hands
    public ArrayList<Card> dealCards() {
        System.out.println(Card.class);
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            Collections.shuffle(cards);
            this.randomCard = cards.get(0);
            playersHand.add((Card) randomCard);
            cards.remove(0);
        }
        ArrayList<Card> player2 = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            Collections.shuffle(cards);
            player2.add((Card) randomCard);
            cards.remove(0);
        }
        ArrayList<Card> player3 = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            Collections.shuffle(cards);
            player3.add((Card) randomCard);
            cards.remove(0);
        }
        System.out.println(playersHand);

        return player2;
    }



    public void reviewCards() {
        Card card1 = playersHand.get(0);
        Card card2 = playersHand.get(1);
        Card card3 = playersHand.get(2);
        Card card4 = playersHand.get(3);
        Card card5 = playersHand.get(4);
        Card card6 = playersHand.get(5);
        Card card7 = playersHand.get(6);
        Card card8 = playersHand.get(7);
        System.out.println("Your Cards are: " + card1.getTitle() +", "+ card2.getTitle() +", "+ card3.getTitle()+", "+ card4.getTitle()+", "+ card5.getTitle()+", "+ card6.getTitle()+", "+ card7.getTitle()+ ", "+card8.getTitle());
    }

    public void chooseCardToPlay() {
        String name = new String();
        name = getName();
        for (int j = 0; j < playersHand.size(); j++) {
            Card card = playersHand.get(j);
            if (name.equals(card.getTitle())) {
                playCards(card);
                break;
            } else
                
        }
    }



    private String getName() {
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the card you wish to play: ");
        name = input.nextLine();
        return name;

    }
    private void playCards(Card card) {
        System.out.println("You have chosen to play the " + card.getTitle() + "card");
        playersHand.remove(card);
        System.out.println("Your remaining Cards: ");
        for (int x = 0; x < playersHand.size(); x++) {
            card = playersHand.get(x);
            System.out.println(card.getTitle());
        }
    }

}





























