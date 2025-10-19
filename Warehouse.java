package service;

import model.Product;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String, Product> inventory = new HashMap<>();
    private AlertService alertService;

    public Warehouse(AlertService alertService) {
        this.alertService = alertService;
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println(" Product added: " + product.getName());
    }

    public void receiveShipment(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            System.out.println(" Shipment received for " + product.getName() + 
                               " | New Quantity: " + product.getQuantity());
        } else {
            System.out.println(" Product not found!");
        }
    }

    public void fulfillOrder(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println(" Invalid Product ID!");
            return;
        }
        if (product.getQuantity() < quantity) {
            System.out.println(" Insufficient stock for " + product.getName());
            return;
        }

        product.setQuantity(product.getQuantity() - quantity);
        System.out.println(" Order fulfilled for " + product.getName() + 
                           "  | Remaining: " + product.getQuantity());

        if (product.getQuantity() < product.getReorderThreshold()) {
            alertService.onLowStock(product);
        }
    }

    public void viewInventory() {
        System.out.println("\n Current Inventory:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

