package model;
import xmlwise.Plist;
import xmlwise.XmlParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class STGame {
    private static final int NUM_CARDS_TO_DEAL = 8;
    private int numPlayers;
    private int chosenDealer;
    public ArrayList shuffledCards = STDeck.createDeck();
    public ArrayList player1 = STDeck.createDeck();
    public ArrayList player2 = STDeck.createDeck();
    public ArrayList player3 = STDeck.createDeck();
    public ArrayList player4 = STDeck.createDeck();
    public ArrayList player5 = STDeck.createDeck();
    public STGame(int numPlayers){
        this.numPlayers = numPlayers;

    }

    public int getDealer() {
        int chosenDealer;
        chosenDealer = 1 + (int)(Math.random() * numPlayers);
        System.out.println(chosenDealer);
        return chosenDealer;
}


    public void dealCards() {
        ArrayList cards = STDeck.createDeck();
        for (int i = 0; i < numPlayers; i++){
            for (int j = 0; i <= 7; j++) {
                cards = (ArrayList) cards.get((Integer) shuffledCards.get(j));
                cards.remove(j);
                System.out.println(player1);
        }


        }
    }

}