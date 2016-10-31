
package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StartGUI extends JFrame implements ActionListener {
    public int i;
    JLabel header = new JLabel("It is player"+STGame.turn+"'s Turn");
    JButton aButton = new JButton("Next Card");
    JButton bButton = new JButton("Previous Card");
    String cardFileName =  getImageName();
    ImageIcon image = new ImageIcon(getClass().getResource(getImageName()));
    JLabel imageLabel = new JLabel(image);
    Panel p = new Panel();
    Panel r = new Panel();

    public StartGUI() {
        setTitle("Choose a Card");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        setVisible(true);
        add(header);
        add(aButton);
        aButton.addActionListener(this);
        add(p);
//        p.setSize(300, 500);
//        p.setLocation(300, 400);
//        p.add(imageLabel);
//        p.add(aButton);
//        imageLabel.setSize(800, -300);


    }
    public void actionPerformed(ActionEvent e) {
        i++;
        System.out.println(i);
        if (i >= 8)
            i = 0;
        if (i == 1) {
            remove(imageLabel);
            getImageName();
            add(imageLabel);
        } else if (i == 2) {
            remove(imageLabel);
            getImageName();
            add(imageLabel);
        } else if (i == 3) {
            remove(imageLabel);
            getImageName();
            add(imageLabel);
        } else if (i == 4) {
            remove(imageLabel);
            getImageName();
            add(imageLabel);
        } else if (i == 5) {
            remove(imageLabel);
            getImageName();
            add(imageLabel);
        } else if (i == 6) {
            remove(imageLabel);
            getImageName();
            add(imageLabel);
        } else if (i == 7) {
            remove(imageLabel);
            getImageName();
            add(imageLabel);
        } else if (i == 8) {
            remove(imageLabel);
            getImageName();
            add(imageLabel);
        } else {
        }

    }


    public static void main(String[] args) {
        StartGUI rFrame = new StartGUI();
        rFrame.setSize(1200, 900);
        rFrame.setVisible(true);

    }
    public String getImageName() {
        ArrayList<STCard> deck = STDeck.createDeck();
        STCard card = deck.get(i);
        cardFileName = ("images\\"+card.getImageName()+".jpg");

        return cardFileName;
    }

}
