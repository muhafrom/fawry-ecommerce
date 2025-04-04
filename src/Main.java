import models.Product;
import models.Customer;
import services.Cart;
import services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 5, true, 0.2, true, LocalDate.now().plusDays(2));
        Product biscuits = new Product("Biscuits", 150, 3, true, 0.7, true, LocalDate.now().plusDays(1));
        Product tv = new Product("TV", 3000, 2, true, 5.0, false, null);
        Product scratchCard = new Product("ScratchCard", 50, 10, false, null, false, null);
        
        Customer customer = new Customer("Ahmed", 10000);
        
        Cart cart = new Cart();
        cart.add(cheese, 2);        
        cart.add(biscuits, 1);       
        cart.add(tv, 1);             
        cart.add(scratchCard, 1);    
        
        CheckoutService.checkout(customer, cart);
    }
}
