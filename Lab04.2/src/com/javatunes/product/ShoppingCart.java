/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * Clients will create ShoppingCart<Product>, ShoppingCart<MusicItem>, or ShoppingCart<MediaPlayer>
 */
public class ShoppingCart<T extends Product> {
    // storage for the cart's contents
    private Collection<T> items = new ArrayList<T>();  // diamond not used here just to emphasize the T

    public int size() {
        return items.size();
    }
    // return read-only view of collection
    public Collection<T> allItems() {
        return Collections.unmodifiableCollection(items);
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public double total() {
        double result = 0.0;
        for (T item : items) {
            result += item.getPrice();
        }
        return result;
    }
}