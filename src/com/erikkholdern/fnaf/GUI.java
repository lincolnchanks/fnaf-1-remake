package com.erikkholdern.fnaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JButton button;

    public static void main(String[] args){
        GUI gui = new GUI();
        gui.go();
    }

    public void go(){
//        JFrame frame = new JFrame();

        GameFrame gameFrame = new GameFrame();

        // We can call this line of code in Game.java
        // or Launcher.java



        button = new JButton("Click this");

        button.addActionListener(this);


//        // Sets a default close operation
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        // Adds the button to the frame
////        frame.getContentPane().add(button);
//        // Sets the frame size
//        frame.setSize(500, 600);
//        // Prevent frame from being resized
//        frame.setResizable(false);
//        // Makes the frame visible
//        frame.setVisible(true);
//        // Sets the frame title
//        frame.setTitle("FNAF 1 Java Remake");
//
//        // Makes the background color black
//        frame.getContentPane().setBackground(new Color(0xAAAAAA));

        // This sets the image icon to whatever we want it to be
/*
        ImageIcon image = new ImageIcon("lorem.jpg");
        frame.setIconImage(image.getImage());
*/

//        Rectangle buttonDimensions = new Rectangle(30, 30, 50, 50);
//        button.setBounds(150, 200, 220, 50);

//        Dimension buttonDimension = new Dimension(30, 15);
//
//        button.setMinimumSize(buttonDimension);
//        button.setMaximumSize(buttonDimension);
//        button.setPreferredSize(buttonDimension);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("I've been clicked!");
        // We can later attach this event to method calls, such as switching cameras.
    }
}
