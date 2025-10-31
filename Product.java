package model;

public class Product {
    private String productId;
    private String name;
    private int quantity;
    private int reorderThreshold;

    public Product(String productId, String name, int quantity, int reorderThreshold) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.reorderThreshold = reorderThreshold;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public boolean isLowStock() {
        return quantity <= reorderThreshold;
    }

    @Override
    public String toString() {
        return productId + " - " + name + " | Qty: " + quantity + " | Threshold: " + reorderThreshold;
    }
}
