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
        System.out.println("The chosen Dealer is: Player "+chosenDealer);
        return chosenDealer;
    }


    //Shuffle Cards then deal them into hands
    public void dealCards() {
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
        ArrayList<Card> player4 = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            Collections.shuffle(cards);
            player4.add((Card) randomCard);
            cards.remove(0);


        }
    }


    public void reviewCards() {
        System.out.println("Your Hand of cards is: ");
        for (int x = 0; x < playersHand.size(); x++) {
            Card card = playersHand.get(x);
            System.out.println(card.getTitle());
            System.out.println("Crystal System: "+card.getCrystal_system()+ ", Classification: " + card.getClassification());
            System.out.println("Hardness: "+card.getHardness()+", Chemistry: "+card.getChemistry()+", Specified Gravity: "+ card.getSpecific_gravity());
            System.out.println("Crustal Abundance: "+card.getCrustal_abundance()+", Economic Value: " +card.getEconomic_value()+", Cleavage: "+card.getCleavage());
        }
    }

    public Card chooseCardToPlay() {
        String name = new String();
        name = getName();
        for (int j = 0; j < playersHand.size(); j++) {
            Card card = playersHand.get(j);
            if (name.equals(card.getTitle())) {
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
        playersHand.remove(card);
        System.out.println("Your remaining Cards: ");
        for (int x = 0; x < playersHand.size(); x++) {
            card = playersHand.get(x);
            System.out.println(card.getTitle());
        }
    }

    public void chooseCatergory() {
        String category = new String();
        Scanner input = new Scanner(System.in);
        System.out.print("Please Choose a playing Category(Cleavage, Hardness, specified gravity, Economic Value, Crustal Abundance): ");
        category = input.nextLine();
        if (category.equalsIgnoreCase("Cleavage")){System.out.println("you have chosen the "+category+ " Category");}
            else if(category.equalsIgnoreCase("Hardness")){System.out.println("you have chosen the "+category+ " Category");}
                else if(category.equalsIgnoreCase("Specified gravity")){System.out.println("you have chosen the "+category+ " Category");}
                    else if(category.equalsIgnoreCase("economic value")){System.out.println("you have chosen the "+category+ " Category");}
                        else if (category.equalsIgnoreCase("crustal abundance")){System.out.println("you have chosen the "+category+ " Category");}
            else{
            System.out.println("Incorrect input, Please enter a valid input. ");
            chooseCatergory();

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
    public static int computeEconomicalValue(Card playerCard){
        int economicValue = 0;
        if (playerCard.getEconomic_value().equals("trivial")){
            economicValue = 0;
        }
        if (playerCard.getEconomic_value().equals("low")){
            economicValue = 1;
        }
        if (playerCard.getEconomic_value().equals("moderate")){
            economicValue = 2;
        }
        if (playerCard.getEconomic_value().equals("high")){
            economicValue = 3;
        }
        if (playerCard.getEconomic_value().equals("very high")){
            economicValue = 4;
        }
        if (playerCard.getEconomic_value().equals("I&apos;m rich!")){
            economicValue = 5;
        }
        return economicValue;
    }
    public static int computeHardness(Card playerCard){
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
    public static int computeCrustal(Card playerCard){
        int crustalNo;
        if (playerCard.getCrustal_abundance().equals("ultratrace")){
            crustalNo = 0;
        }
        if (playerCard.getCrustal_abundance().equals("trace")){
            crustalNo = 1;
        }
        if (playerCard.getCrustal_abundance().equals("low")){
            crustalNo = 2;
        }
        if (playerCard.getCrustal_abundance().equals("moderate"){
            crustalNo = 3;
        }
        if (playerCard.getCrustal_abundance().equals("high")){
            crustalNo = 4;
        }
        if (playerCard.getCrustal_abundance().equals("very high")){
            crustalNo = 5;
        }
        return crustalNo;

    }
    public static int computeGravity(Card playerCard){
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






























