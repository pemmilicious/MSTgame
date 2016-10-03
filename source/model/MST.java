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
    }
    private static void exitGame() {
        System.out.println("catchya later");
    }
    private static void newGameStart() {


        int round = 0;
        int numPlayers = getNumPlayers();
        STGame game = new STGame(numPlayers);
        game.getDealer();
        game.dealCards();
        game.reviewCards();
        game.startRounds();

//        }while (game.player1.size() != 0 & game.player2.size() != 0 & game.player3.size() != 0 & game.player4.size() != 0);
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