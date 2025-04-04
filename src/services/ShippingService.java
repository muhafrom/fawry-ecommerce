package services;

import models.Shippable;
import java.util.List;

public class ShippingService {
    public static double processShipping(List<Shippable> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Shippable item : items) {
            System.out.println(item.getName() + " " + String.format("%.2f", item.getWeight()) + "kg");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight " + String.format("%.2f", totalWeight) + "kg");
        // Shipping fee = 5EGP per kg
        return totalWeight * 5;
    }
}
