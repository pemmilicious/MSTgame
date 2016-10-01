package model;
import xmlwise.Plist;
import xmlwise.XmlParseException;

import javax.smartcardio.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static sun.audio.AudioPlayer.player;

public class STGame {
    private static final int NUM_CARDS_TO_DEAL = 8;
    private int numPlayers;
    private int chosenDealer;;
    public Object randomCard;
    public ArrayList cards = STDeck.createDeck();

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
    public void dealCards() {
        ArrayList<Card> playersHand = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            playersHand.add(randomCardFromDeck(randomCard));
        }
        ArrayList<Card> player2 = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            player2.add(randomCardFromDeck(randomCard));
        }
        ArrayList<Card> player3 = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
            player3.add(randomCardFromDeck(randomCard));
        }
        System.out.println(playersHand);
        System.out.println(player2);
        System.out.println(player3);

    }

    private Card randomCardFromDeck(Object randomCard) {
        Collections.shuffle(cards);
        this.randomCard = cards.get(0);
        cards.remove(0);
        return (Card) this.randomCard;
    }


}





























