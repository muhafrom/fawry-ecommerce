package services;

import models.Product;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();
    
    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive for product: " + product.getName());
        }
        int currentQuantity = items.getOrDefault(product, 0);
        if (currentQuantity + quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Cannot add " + quantity + " of " + product.getName() + ". Already in cart: " + currentQuantity + ", Available: " + product.getQuantity());
        }
        items.put(product, currentQuantity + quantity);
    }
    
    public Map<Product, Integer> getItems() {
        return items;
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
