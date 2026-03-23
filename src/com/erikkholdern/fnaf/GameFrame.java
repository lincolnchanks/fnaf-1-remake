package com.erikkholdern.fnaf;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("FNAF 1 Java Remake");
        this.getContentPane().setBackground(new Color(0xAAAAAA));
    }
}
