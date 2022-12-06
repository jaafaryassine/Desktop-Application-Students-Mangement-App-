package org.example;

import javax.swing.*;

public class HomePage {
    public HomePage(){
        JFrame frame = new JFrame();
        JLabel lb = new JLabel("sjjdjsj");
        frame.add(lb);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        HomePage test = new HomePage();
    }
}

