package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ViewGroceries extends GradientPanel {
    Main gui;
    public JTextArea txaItem;
    public JComboBox<Item> cmbResult;
    JTextField txtName;
    public ViewGroceries(Main gui) {
        super(new Color(0x3E61FF), new Color(0xB2B6FF), GradientPanel.DIAGONAL_FILL);
        this.gui = gui;
        setLayout(new MigLayout("insets 10 30 50 30, gap 40 15"));

        JLabel lblTitle = new JLabel("viewing groceries", JLabel.CENTER);
        lblTitle.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 26));
        lblTitle.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0xB093E0), 4, true),
                "welcome to",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16),
                new Color(0xebddff)));
        lblTitle.setForeground(Color.white);

        txaItem = new JTextArea("", 20, 20);
        txaItem.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        txaItem.setLineWrap(true);
        txaItem.setEditable(false);
        txaItem.setOpaque(false);
        txaItem.setMargin(new Insets(5, 5, 5, 5));
        txaItem.setCaretColor(new Color(0, 0, 0, 0));

        JScrollPane scrItem = new JScrollPane(txaItem, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrItem.setOpaque(false);
        scrItem.getViewport().setOpaque(false);
        scrItem.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 3, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        JLabel lblSearch = new JLabel("Search:");
        lblSearch.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblSearch.setForeground(Color.white);

        JTextField txtSearch = new JTextField();
        txtSearch.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        txtSearch.setMargin(new Insets(5, 5, 5, 5));
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                search(txtSearch.getText());
            }
        });

        JLabel lblResult = new JLabel("Search Result:");
        lblResult.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lblResult.setForeground(Color.white);

        cmbResult = new JComboBox<>();
        cmbResult.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        cmbResult.setForeground(Color.black);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblName.setForeground(Color.white);

        txtName = new JTextField();
        txtName.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        txtName.setMargin(new Insets(5, 5, 5, 5));
        txtName.setEditable(false);

        JLabel lblSku = new JLabel("SKU:");
        lblSku.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lblSku.setForeground(Color.white);

        JTextField txtSku = new JTextField();
        txtSku.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        txtSku.setMargin(new Insets(5, 5, 5, 5));
        txtSku.setEditable(false);

        JLabel lblCate = new JLabel("Category:");
        lblCate.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lblCate.setForeground(Color.white);

        JTextField txtCate = new JTextField();
        txtCate.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        txtCate.setMargin(new Insets(5, 5, 5, 5));
        txtCate.setEditable(false);

        JLabel lblQty = new JLabel("Qty:");
        lblQty.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lblQty.setForeground(Color.white);

        JTextField txtQty = new JTextField();
        txtQty.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        txtQty.setMargin(new Insets(5, 5, 5, 5));
        txtQty.setEditable(false);

        JLabel lblMinQty = new JLabel("Min. Qty:");
        lblMinQty.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lblMinQty.setForeground(Color.white);

        JTextField txtMinQty = new JTextField();
        txtMinQty.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        txtMinQty.setMargin(new Insets(5, 5, 5, 5));
        txtMinQty.setEditable(false);

        JLabel lblVndPrc = new JLabel("Vendor Price:");
        lblVndPrc.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lblVndPrc.setForeground(Color.white);

        JTextField txtVndPrc = new JTextField();
        txtVndPrc.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        txtVndPrc.setMargin(new Insets(5, 5, 5, 5));
        txtVndPrc.setEditable(false);

        JLabel lblMrkPct = new JLabel("Markup:");
        lblMrkPct.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lblMrkPct.setForeground(Color.white);

        JTextField txtMrkPct = new JTextField();
        txtMrkPct.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        txtMrkPct.setMargin(new Insets(5, 5, 5, 5));
        txtMrkPct.setEditable(false);

        JLabel lblRegPrc = new JLabel("Reg. Price:");
        lblRegPrc.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lblRegPrc.setForeground(Color.white);

        JTextField txtRegPrc = new JTextField();
        txtRegPrc.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        txtRegPrc.setMargin(new Insets(5, 5, 5, 5));
        txtRegPrc.setEditable(false);

        JLabel lblCurDsc = new JLabel("Cur. Discount:");
        lblCurDsc.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lblCurDsc.setForeground(Color.white);

        JTextField txtCurDsc = new JTextField();
        txtCurDsc.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        txtCurDsc.setMargin(new Insets(5, 5, 5, 5));
        txtCurDsc.setEditable(false);

        JLabel lblCurPrc = new JLabel("Current Price:");
        lblCurPrc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblCurPrc.setForeground(Color.white);

        JTextField txtCurPrc = new JTextField();
        txtCurPrc.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        txtCurPrc.setMargin(new Insets(5, 5, 5, 5));
        txtCurPrc.setEditable(false);

        JSeparator spr = new JSeparator(JSeparator.HORIZONTAL);
        spr.setForeground(Color.black);

        JButton btnAddItems = new JButton("Add Items");
        btnAddItems.setFocusable(false);
        btnAddItems.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
        btnAddItems.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        btnAddItems.setForeground(Color.black);
        btnAddItems.setContentAreaFilled(false);
        btnAddItems.addMouseListener(new MouseAdapter() {
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
        btnAddItems.addActionListener(gui);


        cmbResult.addActionListener(e -> {
            Item i = (Item) cmbResult.getSelectedItem();
            System.out.println(i);
            txtName.setText(i.getName());
            txtSku.setText(i.getSku());
            txtCate.setText(i.getCategory());
            txtQty.setText(i.getQty() + "");
            txtMinQty.setText(i.getMinQty() + "");
            txtVndPrc.setText(i.getVendorPrice() + "");
            txtMrkPct.setText(i.getMarkupPercent() + "%");
            txtRegPrc.setText("$" + i.getRegPrice());
            txtCurDsc.setText(i.getCurDiscount() + "%");
            txtCurPrc.setText("$" + i.getCurPrice());
        });

        add(lblTitle, "wrap, pushx, growx, span");

        add(scrItem, "span, wrap, push, grow");

        add(lblSearch, "span, split 2");
        add(txtSearch, "pushx, growx, wrap");

        add(lblResult, "span, split 2");
        add(cmbResult, "pushx, growx, wrap");

        add(lblName, "span, split 2");
        add(txtName, "pushx, growx, wrap");

        add(lblSku, "split 2");
        add(txtSku, "pushx, growx");
        add(lblCate, "split 2");
        add(txtCate, "pushx, growx, wrap");

        add(lblQty, "split 2");
        add(txtQty, "pushx, growx");
        add(lblMinQty, "split 2");
        add(txtMinQty, "pushx, growx, wrap");

        add(lblVndPrc, "split 2");
        add(txtVndPrc, "pushx, growx");
        add(lblMrkPct, "split 2");
        add(txtMrkPct, "pushx, growx, wrap");

        add(lblRegPrc, "split 2");
        add(txtRegPrc, "pushx, growx");
        add(lblCurDsc, "split 2");
        add(txtCurDsc, "pushx, growx, wrap");

        add(lblCurPrc, "span, split 2");
        add(txtCurPrc, "pushx, growx, wrap");

        add(spr, "span, pushx, growx, wrap");

        add(btnAddItems, "span, pushx, growx, wrap");
    }

    void search(String str) {
        DefaultComboBoxModel<Item> cmbModel = new DefaultComboBoxModel<>();
        gui.itemList.forEach(item -> {
            if(item.toString().toLowerCase().contains(str)) {
                cmbModel.addElement(item);
            }
        });
        cmbResult.setModel(cmbModel);
        cmbResult.showPopup();

        if(cmbResult.getSelectedIndex() == 0) {
            txtName.setText("Please select an item from the dropdown menu.");
        }
    }
}
