package model;
import model.MST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RulesGUI extends JFrame implements ActionListener {
    public int counter = 0;
    FlowLayout flow = new FlowLayout();
    JButton b = new JButton("Next Rule ");
    JLabel stars = new JLabel("***************************************************************************");
    JTextArea f1 = new JTextArea("1. A dealer (randomly chosen) shuffles the cards and deals each player 8\n" +
            "cards. Each player can look at their cards, but should not show them to\n" +
            "other players. The remaining card pack is placed face down on the table.\n");
    JTextArea f2 = new JTextArea("2. The player to the left of the dealer goes first \n" +
            "by placing a mineral card on"+
            "the table. The player must state the mineral\n name, one of the five trump\n" +
                    "categories (i.e., either Hardness, Specific Gravity, Cleavage, Crustal\n" +
                    "Abundance, or Economic Value), and the top value of that category. For\n" +
                    "example, a player placing the Glaucophane card may state “Glaucophane,\n" +
                    "Specific Gravity, 3.2”\n");
    JTextArea f3 = new JTextArea("3. The player next to the left takes the next turn. This player must play a\n" +
            "mineral card that has a higher value in the trump category than the card\n" +
            "played by the previous player. In the case of the example of the\n" +
            "Glaucophane card above, the player must place a card that has a value for\n" +
            "specific gravity above 3.2. The game continues with the next player to the\n" +
            "left, and so on.\n");
    JTextArea f4 = new JTextArea("4. If a player does not have any mineral cards that are of higher value for the\n" +
            "specific trump category being played, then the player must pass and pick up\n" +
            "one card from the card pack on the table. The player then cannot play again\n" +
            "until all but one player has passed, or until another player throws a\n" +
            "supertrump card to change the trump category, as described below. A player\n" +
            "is allowed to pass even if they still hold cards that could be played. \n");
    JTextArea f5 = new JTextArea(                "5. If the player has a supertrump card (The Miner, The Geologist, The\n" +
            "Geophysicist, The Petrologist, The Mineralogist, The Gemmologist) they\n" +
            "may play this card at any of their turns. By placing a supertrump card, the\n" +
            "player changes the trump category according to the instructions on the\n" +
            "supertrump card. The player then plays a mineral card of their choice to\n" +
            "resume play. At this stage, any other player who had passed on the previous\n" +
            "round is now able to play again. If a player happens to hold both The\n" +
            "Geophysicist card and the Magnetite card in their hand, then that player can\n" +
            "place both cards together to win the round.\n");
    JTextArea f6 = new JTextArea("6. The game continues with players taking turns to play cards until all but one\n" +
            "player has passed. The last player then gets to lead out the next round and\n" +
            "chooses the trump category to be played.\n");
    JTextArea f7 = new JTextArea("7. The winner of the game is the first player to lose all of their cards. The\n" +
            "game continues until all but one player (i.e., the loser) has lost their cards. ");


    public RulesGUI() {
        super("Facts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(flow);
        add(b);
        add(stars);
        add(f1);
        b.addActionListener(this);
    }

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ++counter;
        if (counter == 7)
            MST.displayMenu();
        if (counter == 1) {
            remove(f1);
            add(f2);
        } else if (counter == 2) {
            remove(f2);
            add(f3);
        } else if (counter == 3) {
            remove(f3);
            add(f4);
        } else if (counter == 4) {
            remove(f4);
            add(f5);
        } else if (counter == 5) {
            remove(f5);
            add(f6);
        } else if (counter == 6) {
            remove(f6);
            add(f7);
        } else {

        }

        validate();
        repaint();
    }
}
