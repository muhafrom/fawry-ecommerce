package models;

import java.time.LocalDate;

public class Product implements Shippable {
    private String name;
    private double price;
    private int quantity;
    
    private boolean requiresShipping;
    private Double weight;  // kg

    private boolean isExpirable;
    private LocalDate expiryDate;
    
    public Product(String name, double price, int quantity, boolean requiresShipping, Double weight, boolean isExpirable, LocalDate expiryDate) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be negative");
        }
        if (requiresShipping) {
            if (weight == null || weight <= 0) {
                throw new IllegalArgumentException("Shippable product must have a positive weight");
            }
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.requiresShipping = requiresShipping;
        this.weight = weight;
        this.isExpirable = isExpirable;
        this.expiryDate = expiryDate;
    }
    
    public boolean isExpirable() {
        return isExpirable;
    }
    
    public boolean isExpired() {
        if (isExpirable && expiryDate != null) {
            return LocalDate.now().isAfter(expiryDate);
        }
        return false;
    }
    
    public boolean isShippable() {
        return requiresShipping;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double getWeight() {
        return (requiresShipping && weight != null) ? weight : 0.0;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void reduceQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Can't reduce more than available");
        }
        this.quantity -= amount;
    }
}
