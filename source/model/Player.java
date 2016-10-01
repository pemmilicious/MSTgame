package model;

import javax.swing.*;

/**
 * Created by Bradley on 2/10/2016.
 */
public class Player {
    int playerIndex;
    String playerName;
    boolean isDealer;
    boolean currentPlayer;

    public Player(int playerIndex, String playerName) {
        this.playerName = playerName;
        this.playerIndex = playerIndex;
        this.isDealer = false;
        this.currentPlayer = false;
    }

    public Player(String playerName) {

    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(byte playerIndex) {
        this.playerIndex = playerIndex;
    }

    public String getPlayerName() {
        String playerNameString = JOptionPane.showInputDialog(null,
                "Enter your Name: ");
        playerName = playerNameString;
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isDealer() {
        return isDealer;
    }

    public void setDealer(boolean dealer) {
        isDealer = dealer;
    }

}
