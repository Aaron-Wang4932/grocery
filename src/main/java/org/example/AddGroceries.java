package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

public class AddGroceries extends GradientPanel {
    Main gui;
    public AddGroceries(Main gui) {
        super(new Color(0x3E61FF), new Color(0xB2B6FF), GradientPanel.DIAGONAL_FILL);
        this.gui = gui;
        setLayout(new MigLayout("insets 10 30 50 30, gap 40 15"));
        setPreferredSize(new Dimension(500, 500));

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

        JLabel lblQty = new JLabel("Qty:");
        lblQty.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblQty.setForeground(Color.white);

        JTextField txtQty = new JTextField();
        txtQty.setMargin(new Insets(5, 5, 5, 5));
        txtQty.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

        JLabel lblMinQty = new JLabel("Min. Qty:");
        lblMinQty.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblMinQty.setForeground(Color.white);

        JTextField txtMinQty = new JTextField();
        txtMinQty.setMargin(new Insets(5, 5, 5, 5));
        txtMinQty.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

        JLabel lblMrkPct = new JLabel("Markup:");
        lblMrkPct.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblMrkPct.setForeground(Color.white);

        JTextField txtMrkPct = new JTextField();
        txtMrkPct.setMargin(new Insets(5, 5, 5, 5));
        txtMrkPct.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

        JLabel lblCurDsc = new JLabel("Cur. Discount:");
        lblCurDsc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblCurDsc.setForeground(Color.white);

        JTextField txtCurDsc = new JTextField();
        txtCurDsc.setMargin(new Insets(5, 5, 5, 5));
        txtCurDsc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

        JLabel lblVndPrc = new JLabel("Vendor Price:");
        lblVndPrc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblVndPrc.setForeground(Color.white);

        JTextField txtVndPrc = new JTextField();
        txtVndPrc.setMargin(new Insets(5, 5, 5, 5));
        txtVndPrc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

        JButton btnSave = new JButton("Save Info");
        btnSave.setFocusable(false);
        btnSave.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
        btnSave.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        btnSave.setForeground(Color.black);
        btnSave.setContentAreaFilled(false);
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBorder(BorderFactory.createLineBorder(new Color(0xff6868), 3, true));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
            }
        });

        JTextField txtOut = new JTextField();
        txtOut.setMargin(new Insets(5, 5, 5, 5));
        txtOut.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        txtOut.setEditable(false);

        JButton btnBack = new JButton("View Items");
        btnBack.setFocusable(false);
        btnBack.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
        btnBack.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        btnBack.setForeground(Color.black);
        btnBack.setContentAreaFilled(false);
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBorder(BorderFactory.createLineBorder(new Color(0xff6868), 3, true));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
            }
        });


        add(lblTitle, "wrap, pushx, growx, span");

        add(lblSKU, "split 4");
        add(cmbSKU, "pushx, growx");
        add(lblHyphen);
        add(txtID, "pushx, growx");
        add(lblName, "split 2");
        add(txtName, "pushx, growx, wrap");

        add(lblQty, "split 2");
        add(txtQty, "pushx, growx");
        add(lblMinQty, "split 2");
        add(txtMinQty, "pushx, growx, wrap");

        add(lblMrkPct, "split 2");
        add(txtMrkPct, "pushx, growx");
        add(lblCurDsc, "split 2");
        add(txtCurDsc, "pushx, growx, wrap");

        add(lblVndPrc, "split 2");
        add(txtVndPrc, "pushx, growx");
        add(btnSave, "pushx, growx, wrap");

        add(txtOut, "pushx, growx, span, height 100");

        add(btnBack, "pushx, growx, span");
    }

}
