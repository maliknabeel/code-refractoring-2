package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.IntroduceParameterObjectExample.*;

public class IntroduceParameterObjectExampleGoodExample {
    public static class Customer {
        final String name;
        final String email;
        final String address;

        public Customer(String name, String email, String address) {
            this.name    = name;
            this.email   = email;
            this.address = address;
        }
    }

    public static class OrderDetails {
        final double price;
        final int    quantity;
        final double taxRate;

        public OrderDetails(double price, int quantity, double taxRate) {
            this.price    = price;
            this.quantity = quantity;
            this.taxRate  = taxRate;
        }

        double subtotal() { return price * quantity; }
    }

    public double calculateTotal(Customer customer, OrderDetails order) {
        // 2 meaningful parameters instead of 6 primitives
        double subtotal = order.subtotal();
        return subtotal + (subtotal * order.taxRate / 100);
    }
}
