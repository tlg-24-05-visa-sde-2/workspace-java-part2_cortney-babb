/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.Location;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;

import java.util.Collection;

public class Order {
    private final String id;
    private final Location location;
    private double subTotal;


    public Order(String id, Location location) {
        this.location = location;
        this.id = id;
    }

    // instead of doing calculation here, delegate to one of the TaxCalculator strategies
    // we omit saying "new" here
    //  Ex.        TaxCalculator calc = new USATax();
    // instead, we fetch it from factory, "pull" model
    public double getTax() {
        TaxCalculator calc = TaxCalculatorFactory.createTaxCalculator(getLocation());

        return calc.taxAmount(getSubTotal());
    }

    /**
     * DONE:
     * get the items from the cart and iterate over them, print each item's product code
     * get cart total and print
     */
    public void processCart(ShoppingCart<? extends Product> cart) {
        System.out.println("Order: " + getId() + " contains the following:");

        Collection<? extends Product> cartItems = cart.allItems();
        for (Product product : cartItems) {
            System.out.println(product.getCode());
        }

        double subtotal = cart.total();
        System.out.println("Order Total: " + subtotal);
        this.subTotal = subtotal;
    }

    public String getId() {
        return id;
    }

    // Getters
    public Location getLocation() {
        return location;
    }

    public double getSubTotal() {
        return subTotal;
    }
}