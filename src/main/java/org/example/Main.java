package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JFrame implements ActionListener {

    public ArrayList<Item> itemList = new ArrayList<>();
    File itemFile = new File("src/main/resources/inventory.txt");
    ViewGroceries pnlViewGroceries;
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("groceries bruh");
        setPreferredSize(new Dimension(1000, 1000));
        setMinimumSize(new Dimension(700, 700));

        pnlViewGroceries = new ViewGroceries(this);

        add(pnlViewGroceries);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        try {
            new Main().loadItems();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void loadItems() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(itemFile));
        String temp;
        String[] tempSplit;

        while((temp = br.readLine()) != null) {
            tempSplit = temp.split(",");
            itemList.add(new Item(
                    tempSplit[0],
                    tempSplit[1],
                    Integer.parseInt(tempSplit[3]),
                    Integer.parseInt(tempSplit[4]),
                    Double.parseDouble(tempSplit[5]),
                    Double.parseDouble(tempSplit[6]),
                    Double.parseDouble(tempSplit[8])
                    ));
        }

        pnlViewGroceries.txaItem.setText("");

        itemList.forEach(item -> {
            pnlViewGroceries.txaItem.append(item + "\n");
        });


    }
}