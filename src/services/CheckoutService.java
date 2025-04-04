package services;

import models.Customer;
import models.Product;
import models.Shippable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutService {
    public static String checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            return "Cart is empty";
        }
    
        double subtotal = 0;
        List<Shippable> shippingItems = new ArrayList<>();
        
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            
            if (product.isExpirable() && product.isExpired()) {
                return "Product " + product.getName() + " is expired";
            }
            if (quantity > product.getQuantity()) {
                return "Product " + product.getName() + " is out of stock";
            }
            
            if (product.isShippable()) {
                for (int i = 0; i < quantity; i++) {
                    shippingItems.add(product);
                }
            }
            
            subtotal += product.getPrice() * quantity;
        }
    
        double shippingFee = shippingItems.isEmpty() ? 0 : ShippingService.processShipping(shippingItems);
        double total = subtotal + shippingFee;
        
        if (customer.getBalance() < total) {
            return "Insufficient balance";
        }
    
        customer.deduct(total);
    
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }
    
        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + "x " + product.getName() + " " + String.format("%.2f", (product.getPrice() * quantity)) + " EGP");
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + String.format("%.2f", subtotal) + " EGP");
        System.out.println("Shipping " + String.format("%.2f", shippingFee) + " EGP");
        System.out.println("Amount " + String.format("%.2f", total) + " EGP");
        System.out.println("Customer current balance after payment: " + String.format("%.2f", customer.getBalance()) + " EGP");
    
        return "Checkout successful!";
    }
}    