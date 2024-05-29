package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("groceries bruh");
        setPreferredSize(new Dimension(700, 1000));
        setMinimumSize(new Dimension(700, 700));

        ViewGroceries pnlViewGroceries = new ViewGroceries();

        add(pnlViewGroceries);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}