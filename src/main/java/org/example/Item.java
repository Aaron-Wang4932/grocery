package org.example;

public class Item {
    private String sku;
    private String name;
    private String category;
    private int qty;
    private int minQty;
    private double vendorPrice;
    private double markupPercent;
    private double regPrice;
    private double curDiscount;
    private double curPrice;

    public Item(String sku, String name, int qty, int minQty, double vendorPrice,
                double markupPercent, double curDiscount) {
        this.sku = sku;
        this.name = name;
        this.qty = qty;
        this.minQty = minQty;
        this.vendorPrice = vendorPrice;
        this.markupPercent = markupPercent;
        this.curDiscount = curDiscount;

        if(sku.startsWith("FRU")) this.category = "FRUIT";
        else if(sku.startsWith("VEG")) this.category = "VEGETABLE";
        else if(sku.startsWith("MEA")) this.category = "MEAT";
        else this.category = "INVALID";

        this.regPrice = vendorPrice * (1 + markupPercent/100);

        this.curPrice = regPrice * (1 - curDiscount/100);

        // Rounding double values
        this.vendorPrice = Math.round(vendorPrice * 100) / 100.0;
        this.markupPercent = Math.round(markupPercent * 100) / 100.0;
        this.regPrice = Math.round(regPrice * 100) / 100.0;
        this.curDiscount = Math.round(curDiscount * 100) / 100.0;
        this.curPrice = Math.round(curPrice * 100) / 100.0;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }

    public double getVendorPrice() {
        return vendorPrice;
    }

    public void setVendorPrice(double vendorPrice) {
        this.vendorPrice = vendorPrice;
    }

    public double getMarkupPercent() {
        return markupPercent;
    }

    public void setMarkupPercent(double markupPercent) {
        this.markupPercent = markupPercent;
    }

    public double getRegPrice() {
        return regPrice;
    }

    public void setRegPrice(double regPrice) {
        this.regPrice = regPrice;
    }

    public double getCurDiscount() {
        return curDiscount;
    }

    public void setCurDiscount(double curDiscount) {
        this.curDiscount = curDiscount;
    }

    public double getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(double curPrice) {
        this.curPrice = curPrice;
    }

    @Override
    public String toString() {
        return sku + "," + name + "," + category + "," + qty + "," + minQty + "," +
                vendorPrice + "," + markupPercent + "," + regPrice + "," + curDiscount + "," + curPrice;
    }
}
