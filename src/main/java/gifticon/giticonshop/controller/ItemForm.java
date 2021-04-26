package gifticon.giticonshop.controller;

public class ItemForm {
    private String name;
    private int price;
    private int stock;

    public ItemForm(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
