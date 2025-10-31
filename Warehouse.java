package service;

import model.Product;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final String name;
    private final Map<String, Product> inventory = new HashMap<>();
    private final AlertService alertService;

    public Warehouse(String name, AlertService alertService) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Warehouse name required");
        if (alertService == null) throw new IllegalArgumentException("AlertService cannot be null");
        this.name = name;
        this.alertService = alertService;
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        if (product == null) return;
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product already exists in " + name);
            return;
        }
        inventory.put(product.getProductId(), product);
        System.out.println("Product added to " + name + ": " + product.getName());
    }

    public void receiveShipment(String productId, int qty) {
        if (qty <= 0) return;
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("Product not found in " + name);
            return;
        }
        product.setQuantity(product.getQuantity() + qty);
        System.out.println("Shipment received in " + name + ": " + product.getName() + " | New Qty: " + product.getQuantity());
    }

    public void fulfillOrder(String productId, int qty) {
        if (qty <= 0) return;
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("Product not found in " + name);
            return;
        }
        if (qty > product.getQuantity()) {
            System.out.println("Insufficient stock in " + name + " for " + product.getName());
            return;
        }
        product.setQuantity(product.getQuantity() - qty);
        System.out.println("Order fulfilled in " + name + " for " + product.getName() + " | Remaining: " + product.getQuantity());
        if (product.isLowStock()) alertService.onLowStock(product);
    }

    public void viewInventory() {
        System.out.println("\n--- " + name + " Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("No products available");
            return;
        }
        for (Product p : inventory.values()) System.out.println(p);
    }
}
