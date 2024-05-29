package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class AddGroceries extends GradientPanel {
    Main gui;
    public AddGroceries(Main gui) {
        super(new Color(0x3E61FF), new Color(0xB2B6FF), GradientPanel.DIAGONAL_FILL);
        this.gui = gui;
        setLayout(new MigLayout("insets 10 30 50 30, gap 40 15"));

        JLabel lblTitle = new JLabel("adding groceries", JLabel.CENTER);
        lblTitle.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 26));
        lblTitle.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0xB093E0), 4, true),
                "welcome to",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16),
                new Color(0xebddff)));
        lblTitle.setForeground(Color.white);

        JLabel lblSKU = new JLabel("SKU:");
        lblSKU.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblSKU.setForeground(Color.white);

        JComboBox<String> cmbSKU = new JComboBox<>(new String[] {"N/A", "FRU", "VEG", "MEA"});
        cmbSKU.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        cmbSKU.setForeground(Color.black);

        JLabel lblHyphen = new JLabel("—");
        lblHyphen.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblHyphen.setForeground(Color.white);

        JTextField txtID = new JTextField("----");
        txtID.setEditable(false);
        txtID.setMargin(new Insets(5, 5, 5, 5));
        txtID.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblName.setForeground(Color.white);

        JTextField txtName = new JTextField();
        txtName.setMargin(new Insets(5, 5, 5, 5));
        txtName.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));


        add(lblTitle, "wrap, pushx, growx, span");
        add(lblSKU, "split 4");
        add(cmbSKU, "pushx, growx");
        add(lblHyphen);
        add(txtID, "pushx, growx");
        add(lblName, "split 2");
        add(txtName, "pushx, growx, wrap");

    }

}
