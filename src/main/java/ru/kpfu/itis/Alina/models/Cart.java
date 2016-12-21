package ru.kpfu.itis.Alina.models;

import java.util.HashMap;

/**
 * Created by Admin on 05.11.2016.
 */
public class Cart {
    HashMap<String, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<String, Integer>();
    }

    public HashMap getCartItems() {
        return cartItems;
    }

    public void addToCart(String itemId, int price) {
        cartItems.put(itemId, price);
    }

    public void deleteFromCart(String itemId) {
        cartItems.remove(itemId);
    }
}