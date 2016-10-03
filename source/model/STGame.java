package model;
import java.util.Scanner;
import java.util.*;

public class STGame {
    private static final int NUM_CARDS_TO_DEAL = 8;
    private int numPlayers;
    public Object randomCard;
    public ArrayList<Card> cards = STDeck.createDeck();
    public ArrayList<Card> player1 = new ArrayList<>();
    public ArrayList<Card> player3 = new ArrayList<>();
    public ArrayList<Card> player2 = new ArrayList<>();
    public ArrayList<Card> player4 = new ArrayList<>();
    static int turn = 1;



    public STGame(int numPlayers) {
        this.numPlayers = numPlayers;

    }
    public int getDealer() {
        int chosenDealer;
        chosenDealer = 1 + (int) (Math.random() * numPlayers);
        System.out.println("The chosen Dealer is: Player " + chosenDealer);
        return chosenDealer;
    }
    public void dealCards() {
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            Collections.shuffle(cards);
            this.randomCard = cards.get(0);
            player1.add((Card) randomCard);
            cards.remove(0);
        }
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            Collections.shuffle(cards);
            player4.add((Card) randomCard);
            cards.remove(0);
        }
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            Collections.shuffle(cards);
            player2.add((Card) randomCard);
            cards.remove(0);
        }
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            Collections.shuffle(cards);
            player3.add((Card) randomCard);
            cards.remove(0);


        }
    }
    public void reviewCards() {
        System.out.println("Your Hand of cards is: ");
        for (int x = 0; x < player1.size(); x++) {
            Card card = player1.get(x);
            System.out.println(card.getTitle());
//            System.out.println("Hardness: " + card.getHardness() + ", Specified Gravity: " + card.getSpecific_gravity());
//            System.out.println("Crustal Abundance: " + card.getCrustal_abundance() + ", Economic Value: " + card.getEconomic_value() + ", Cleavage: " + card.getCleavage());
        }
    }
    public Card chooseCardToPlay() {
        String name = new String();
        name = getName();
        for (int j = 0; j < player1.size(); j++) {
            Card card = player1.get(j);
            if (name.equals(card.getTitle())) {
                System.out.println("You have chosen " + card.getTitle());
                System.out.println("Hardness: " + card.getHardness() + ", Specified Gravity: " + card.getSpecific_gravity());
                System.out.println("Crustal Abundance: " + card.getCrustal_abundance() + ", Economic Value: " + card.getEconomic_value() + ", Cleavage: " + card.getCleavage());
                playCards(card);
            } else
                System.out.print("");

        }
        return null;
    }
    private String getName() {
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the card you wish to play: ");
        name = input.nextLine();
        return name;

    }
    public void playCards(Card card) {
        System.out.println("You have chosen to play the " + card.getTitle() + "card");
        player1.remove(card);
        System.out.println("Your remaining Cards: ");
        for (int x = 0; x < player1.size(); x++) {
            card = player1.get(x);
            System.out.println(card.getTitle());
        }
    }
    public void startRounds() {
        do {
            if(turn == 1){
                startGame(player1);
                turn++;
                startRounds();
            }
            if(turn == 2){
                startGame(player2);
                turn++;
                startRounds();
            }
            if(turn == 3){
                startGame(player3);
                turn++;
                startRounds();
            }
            if(turn == 4){
                startGame(player4);
                turn++;
                startRounds();
            }


        }while (player1.size() != 0 & player2.size() != 0 & player3.size() != 0 & player4.size() != 0);
    }
    public static void startGame(ArrayList playerCards) {
        for (int i = 0; i < playerCards.size(); i++) {
            Card card = (Card) playerCards.get(i);
            System.out.println(card.getTitle());
        }
    }

    private void chooseCategory() {
        String category = new String();
        Scanner input = new Scanner(System.in);
        System.out.print("Please Choose a playing Category(Cleavage, Hardness, specified gravity, Economic Value, Crustal Abundance): ");
        category = input.nextLine();
        if (category.equalsIgnoreCase("Cleavage")) {
            System.out.println("you have chosen the " + category + " Category");
        } else if (category.equalsIgnoreCase("Hardness")) {
            System.out.println("you have chosen the " + category + " Category");
        } else if (category.equalsIgnoreCase("Specified gravity")) {
            System.out.println("you have chosen the " + category + " Category");
        } else if (category.equalsIgnoreCase("economic value")) {
            System.out.println("you have chosen the " + category + " Category");
        } else if (category.equalsIgnoreCase("crustal abundance")) {
            System.out.println("you have chosen the " + category + " Category");
        } else {
            System.out.println("Incorrect input, Please enter a valid input. ");
            startRounds();
        }
    }
    public static int computeCleavage(Card playerCard) {
        int cleavageNo;
        if (playerCard.getCleavage().equals("none")) {
            cleavageNo = 0;
        }
        if (playerCard.getCleavage().equals("poor/none")) {
            cleavageNo = 1;
        }
        if (playerCard.getCleavage().equals("1 poor")) {
            cleavageNo = 2;
        }
        if (playerCard.getCleavage().equals("2 poor")) {
            cleavageNo = 3;
        }
        if (playerCard.getCleavage().equals("1 good")) {
            cleavageNo = 4;
        }
        if (playerCard.getCleavage().equals("2 good")) {
            cleavageNo = 5;
        }
        if (playerCard.getCleavage().equals("1 good, 1 poor")) {
            cleavageNo = 6;
        }
        if (playerCard.getCleavage().equals("3 good")) {
            cleavageNo = 7;
        }
        if (playerCard.getCleavage().equals("1 perfect")) {
            cleavageNo = 8;
        }
        if (playerCard.getCleavage().equals("1 perfect, 1 good")) {
            cleavageNo = 9;
        }
        if (playerCard.getCleavage().equals("2 perfect, 1 good")) {
            cleavageNo = 10;
        }
        if (playerCard.getCleavage().equals("3 perfect")) {
            cleavageNo = 11;
        }
        if (playerCard.getCleavage().equals("4 perfect")) {
            cleavageNo = 12;
        } else {
            cleavageNo = 13;
        }
        return cleavageNo;
    }
    public static int computeEconomicalValue(Card playerCard) {
        int economicValue = 0;
        if (playerCard.getEconomic_value().equals("trivial")) {
            economicValue = 0;
        }
        if (playerCard.getEconomic_value().equals("low")) {
            economicValue = 1;
        }
        if (playerCard.getEconomic_value().equals("moderate")) {
            economicValue = 2;
        }
        if (playerCard.getEconomic_value().equals("high")) {
            economicValue = 3;
        }
        if (playerCard.getEconomic_value().equals("very high")) {
            economicValue = 4;
        }
        if (playerCard.getEconomic_value().equals("I&apos;m rich!")) {
            economicValue = 5;
        }
        return economicValue;
    }
    public static int computeHardness(Card playerCard) {
        int hardnessNo = 0;
        String hardness1 = playerCard.getHardness();
        if (hardness1.indexOf('-') >= 0) {
            String[] output = hardness1.split("-");
            double sg1 = Double.parseDouble(output[0]);
            double sg2 = Double.parseDouble(output[1]);
            double computedHardness = (sg1 + sg2) / 2;
            return Integer.parseInt(String.format("%.2f", computedHardness));
        } else {
            return Integer.parseInt(playerCard.getHardness());
        }
    }
    public static int computeCrustal(Card playerCard) {
        int crustalNo = 0;
        if (playerCard.getCrustal_abundance().equals("ultratrace")) {
            crustalNo = 0;
        }
        if (playerCard.getCrustal_abundance().equals("trace")) {
            crustalNo = 1;
        }
        if (playerCard.getCrustal_abundance().equals("low")) {
            crustalNo = 2;
        }
        if (playerCard.getCrustal_abundance().equals("moderate")) {
            crustalNo = 3;
        }
        if (playerCard.getCrustal_abundance().equals("high")) {
            crustalNo = 4;
        }
        if (playerCard.getCrustal_abundance().equals("very high")) {
            crustalNo = 5;
        }
        return crustalNo;

    }
    public static int computeGravity(Card playerCard) {
        int gravityNo;
        String gravity1 = playerCard.getSpecific_gravity();
        if (gravity1.indexOf('-') >= 0) {
            String[] output = gravity1.split("-");
            double sg1 = Double.parseDouble(output[0]);
            double sg2 = Double.parseDouble(output[1]);
            double computeGravity = (sg1 + sg2) / 2;
            return Integer.parseInt(String.format("%.2f", computeGravity));
        } else {
            return Integer.parseInt(playerCard.getHardness());
        }
    }


}







jp























