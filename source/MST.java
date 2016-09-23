import javax.swing.*;
public class MST {
    public static void main(String[] args) {
        welcomeMessage();
        displayMenu();
    }

    private static int getUserMenuChoice() {
        return 0;
    }

    private static void displayMenu() {
        String usersChoiceString;
        int usersChoice = 0;
        usersChoiceString = JOptionPane.showInputDialog(null,
                "Enter 1 or 2\n1 - Start Game\n2 - Exit");
        usersChoice = Integer.parseInt(usersChoiceString);
                if (usersChoice == 1){
                    gameStart();}
                else if (usersChoice == 2){
                    exitGame();
                    }
                    else{
                        displayMenu();
                }


    }

    private static void exitGame() {
        System.out.println("catchya later");
    }

    private static void gameStart() {
    }

    private static void welcomeMessage() {
        System.out.println("hello");
    }
}