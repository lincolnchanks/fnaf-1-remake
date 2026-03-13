package com.erikkholdern.fnaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
//    JFrame frame = new JFrame();
//    JButton button = new JButton("Click me");
//
//    public JFrame getFrame(){
//        return frame;
//    }
//
//    public JButton getButton(){
//        return button;
//    }

//    public void changeIt(JButton button){
//
//    }

    public static void main(String[] args){
        GUI launcher = new GUI();
        launcher.run(launcher);
    }

    public void run(GUI launcher){
        JFrame frame = new JFrame();
        JButton button = new JButton("Click this");

        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);
        button.setSize(300, 300);
        button.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
