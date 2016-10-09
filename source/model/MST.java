package model;
import javax.swing.*;
import javax.swing.text.html.CSS;
import java.util.ArrayList;
public class MST {

    public static void main(String[] args) {
        welcomeMessage();
        displayMenu();
    }
    private static void displayMenu() {
        String usersChoiceString;
        int usersChoice = 0;
        usersChoiceString = JOptionPane.showInputDialog(null,
                "Enter 1 or 2\n1 - Start Game\n2 - view Rules\n3 - Exit");
        usersChoice = Integer.parseInt(usersChoiceString);
                if (usersChoice == 1){
                    newGameStart();}
                else if (usersChoice == 2){
                    displayRules();
                    }
                    else if (usersChoice == 3) {
                    exitGame();}
                    else
                        displayMenu();
                    }
    private static void displayRules() {
        System.out.println("1. A dealer (randomly chosen) shuffles the cards and deals each player 8\n" +
                "cards. Each player can look at their cards, but should not show them to\n" +
                "other players. The remaining card pack is placed face down on the table.\n" +
                "2. The player to the left of the dealer goes first by placing a mineral card on\n" +
                "the table. The player must state the mineral name, one of the five trump\n" +
                "categories (i.e., either Hardness, Specific Gravity, Cleavage, Crustal\n" +
                "Abundance, or Economic Value), and the top value of that category. For\n" +
                "example, a player placing the Glaucophane card may state “Glaucophane,\n" +
                "Specific Gravity, 3.2”\n" +
                "3. The player next to the left takes the next turn. This player must play a\n" +
                "mineral card that has a higher value in the trump category than the card\n" +
                "played by the previous player. In the case of the example of the\n" +
                "Glaucophane card above, the player must place a card that has a value for\n" +
                "specific gravity above 3.2. The game continues with the next player to the\n" +
                "left, and so on.\n" +
                "4. If a player does not have any mineral cards that are of higher value for the\n" +
                "specific trump category being played, then the player must pass and pick up\n" +
                "one card from the card pack on the table. The player then cannot play again\n" +
                "until all but one player has passed, or until another player throws a\n" +
                "supertrump card to change the trump category, as described below. A player\n" +
                "is allowed to pass even if they still hold cards that could be played. \n" +
                "5. If the player has a supertrump card (The Miner, The Geologist, The\n" +
                "Geophysicist, The Petrologist, The Mineralogist, The Gemmologist) they\n" +
                "may play this card at any of their turns. By placing a supertrump card, the\n" +
                "player changes the trump category according to the instructions on the\n" +
                "supertrump card. The player then plays a mineral card of their choice to\n" +
                "resume play. At this stage, any other player who had passed on the previous\n" +
                "round is now able to play again. If a player happens to hold both The\n" +
                "Geophysicist card and the Magnetite card in their hand, then that player can\n" +
                "place both cards together to win the round.\n" +
                "6. The game continues with players taking turns to play cards until all but one\n" +
                "player has passed. The last player then gets to lead out the next round and\n" +
                "chooses the trump category to be played.\n" +
                "7. The winner of the game is the first player to lose all of their cards. The\n" +
                "game continues until all but one player (i.e., the loser) has lost their cards. ");
        displayMenu();
    }
    private static void exitGame() {
        System.out.println("catchya later");
    }
    private static void newGameStart() {
        int numPlayers = getNumPlayers();
        STGame game = new STGame(numPlayers);
        game.getDealer();
        game.dealCards();
        game.startRounds();
        }
    private static void welcomeMessage() {
        System.out.println("hello");
    }
    public static int getNumPlayers() {
        String numPlayersString;
        int numPlayers = 0;
        numPlayersString = JOptionPane.showInputDialog(null,
                "Enter the number of players(Min 3, Max 5");
        numPlayers = Integer.parseInt(numPlayersString);
            if(numPlayers > 5 || numPlayers < 3)
                getNumPlayers();
                else
                System.out.println(numPlayers);
        return numPlayers;
    }
}