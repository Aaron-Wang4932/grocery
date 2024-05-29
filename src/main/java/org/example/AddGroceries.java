package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.border.TitledBorder;

public class AddGroceries extends GradientPanel {
    Main gui;
    public AddGroceries(Main gui) {
        super(new Color(0x3E61FF), new Color(0xB2B6FF), GradientPanel.DIAGONAL_FILL);
        this.gui = gui;
        setLayout(new MigLayout("insets 10 30 50 30, gap 40 15"));
        setPreferredSize(new Dimension(500, 650));

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

        JTextField txtID = new JTextField("----");
        txtID.setEditable(false);
        txtID.setMargin(new Insets(5, 5, 5, 5));
        txtID.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

        JComboBox<String> cmbSKU = new JComboBox<>(new String[] {"N/A", "FRU", "VEG", "MEA"});
        cmbSKU.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        cmbSKU.setForeground(Color.black);
        cmbSKU.addActionListener(e -> {
            if(cmbSKU.getSelectedIndex() == 0) {
                txtID.setText("----");
                return;
            }
            int id = getSKU_ID((String) cmbSKU.getSelectedItem());
            txtID.setText(String.format("%04d", id));
        });

        JLabel lblHyphen = new JLabel("—");
        lblHyphen.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblHyphen.setForeground(Color.white);

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
        txtQty.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateInt(e);
            }
        });

        JLabel lblMinQty = new JLabel("Min. Qty:");
        lblMinQty.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblMinQty.setForeground(Color.white);

        JTextField txtMinQty = new JTextField();
        txtMinQty.setMargin(new Insets(5, 5, 5, 5));
        txtMinQty.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        txtMinQty.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateInt(e);
            }
        });

        JLabel lblMrkPct = new JLabel("Markup:");
        lblMrkPct.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblMrkPct.setForeground(Color.white);

        JTextField txtMrkPct = new JTextField();
        txtMrkPct.setMargin(new Insets(5, 5, 5, 5));
        txtMrkPct.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        txtMrkPct.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateDouble(e);
            }
        });


        JLabel lblCurDsc = new JLabel("Cur. Discount:");
        lblCurDsc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblCurDsc.setForeground(Color.white);

        JTextField txtCurDsc = new JTextField();
        txtCurDsc.setMargin(new Insets(5, 5, 5, 5));
        txtCurDsc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        txtCurDsc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateDouble(e);
            }
        });

        JLabel lblVndPrc = new JLabel("Vendor Price:");
        lblVndPrc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblVndPrc.setForeground(Color.white);

        JTextField txtVndPrc = new JTextField();
        txtVndPrc.setMargin(new Insets(5, 5, 5, 5));
        txtVndPrc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        txtVndPrc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateDouble(e);
            }
        });

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

        JTextArea txaOut = new JTextArea();
        txaOut.setMargin(new Insets(5, 5, 5, 5));
        txaOut.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        txaOut.setEditable(false);
        txaOut.setLineWrap(true);
        txaOut.setWrapStyleWord(true);

        JButton btnBack = new JButton("View Items");
        btnBack.setFocusable(false);
        btnBack.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
        btnBack.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        btnBack.setForeground(Color.black);
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(gui);
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
        add(txtVndPrc, "pushx, growx, wrap");

        add(new JScrollPane(txaOut, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), "push, grow, span, height 100");
        add(btnSave, "pushx, growx, span");

        add(btnBack, "pushx, growx, span");

        btnSave.addActionListener(e -> {
            txaOut.setText("");

            if(cmbSKU.getSelectedIndex() == 0) {
                txaOut.append("Select a SKU category.\n");
                return;

            }
            String sku = cmbSKU.getSelectedItem() + "-" + txtID.getText();

            if(txtName.getText().trim().isEmpty()) {
                txaOut.append("Provide an item name.\n");
                return;
            }
            if(txtName.getText().trim().length() > 20) {
                txaOut.append("The name specified is too long.\n");
                return;
            }
            String name = txtName.getText().trim();

            for(Item i : gui.itemList) {
                if(i.getName().equalsIgnoreCase(name)) {
                    txaOut.append("This item already exists.\n");
                    return;
                }
            }


            if(txtQty.getText().trim().isEmpty()) {
                txaOut.append("Provide a quantity.\n");
                return;
            }
            int qty = Integer.parseInt(txtQty.getText().trim());

            if(qty <= 0) {
                txaOut.append("Quantity must be greater than 0.\n");
                return;
            }

            if(txtMinQty.getText().trim().isEmpty()) {
                txaOut.append("Provide a minimum quantity.\n");
                return;
            }
            int minQty = Integer.parseInt(txtMinQty.getText().trim());
            if(minQty >= qty) {
                txaOut.append("Minimum quantity must be less than quantity.\n");
                return;
            }
            if(minQty <= 0) {
                txaOut.append("Minimum quantity must be greater than 0.\n");
                return;
            }

            if(txtMrkPct.getText().trim().isEmpty()) {
                txaOut.append("Enter a markup percentage.\n");
                return;
            }
            double markup = Double.parseDouble(txtMrkPct.getText().trim());

            if(markup <= 0) {
                txaOut.append("Markup percent must be greater than 0%.\n");
                return;
            }

            if(txtCurDsc.getText().trim().isEmpty()) {
                txaOut.append("Enter a current discount percentage.\n");
                return;
            }
            double curDiscount = Double.parseDouble(txtCurDsc.getText().trim());

            if(curDiscount < 0) {
                txaOut.append("Markup percent must be non-negative.\n");
                return;
            }

            if(txtVndPrc.getText().trim().isEmpty()) {
                txaOut.append("Enter the vendor price.\n");
                return;
            }
            double vendorPrice = Double.parseDouble(txtVndPrc.getText().trim());;

            if(vendorPrice <= 0) {
                txaOut.append("Vendor price must be greater than $0.\n");
                return;
            }
            

            Item item = new Item(sku, name, qty, minQty, vendorPrice, markup, curDiscount);
            if(item.getCategory().equalsIgnoreCase("meat")) {
                gui.itemList.add(item);
            } else {
                int insertionIndex = 0;
                for(int i = 0; i < gui.itemList.size(); i++) {
                    if(gui.itemList.get(i).getCategory().equals(item.getCategory()) &&
                       !gui.itemList.get(i+1).getCategory().equals(item.getCategory())) {
                        insertionIndex = i+1;
                        break;
                    }
                }
                gui.itemList.add(insertionIndex, item);
            }

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("resources/inventory.txt"));
                for(Item i : gui.itemList) bw.write(i.toString() + "\n");
                bw.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            txaOut.setText("Your specified item has been added.");

            cmbSKU.setSelectedIndex(0);
            txtName.setText("");
            txtQty.setText("");
            txtMinQty.setText("");
            txtMrkPct.setText("");
            txtCurDsc.setText("");
            txtVndPrc.setText("");




        });
    }

    int getSKU_ID(String sku) {
        int count = 0;
        for(Item i : gui.itemList) if(i.toString().startsWith(sku)) count++;
        return count + 1;
    }

    void validateInt(KeyEvent e) {
        if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            e.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        try {
            Integer.parseInt(((JTextField)e.getSource()).getText());
        } catch (NumberFormatException ignored) {
            ((JTextField)e.getSource()).setText("");
        }
    }
    void validateDouble(KeyEvent e) {
        if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.' && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            e.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        try {
            Double.parseDouble(((JTextField)e.getSource()).getText());
        } catch (NumberFormatException ignored) {
            ((JTextField)e.getSource()).setText("");
        }
    }

}
