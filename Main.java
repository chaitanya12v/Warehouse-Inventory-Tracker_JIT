package main;

import model.Product;
import service.Warehouse;
import service.AlertService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlertService alert = (product) -> {
            System.out.println("4Restock Alert: " + product.getName() + 
                               " is low on stock! Only " + product.getQuantity() + " left.");
        };

        Warehouse warehouse = new Warehouse(alert);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== WAREHOUSE INVENTORY MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Receive Shipment");
            System.out.println("3. Fulfill Order");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String id = sc.next();
                    System.out.print("Enter Product Name: ");
                    String name = sc.next();
                    System.out.print("Enter Initial Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Reorder Threshold: ");
                    int threshold = sc.nextInt();
                    warehouse.addProduct(new Product(id, name, qty, threshold));
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    id = sc.next();
                    System.out.print("Enter Shipment Quantity: ");
                    qty = sc.nextInt();
                    warehouse.receiveShipment(id, qty);
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    id = sc.next();
                    System.out.print("Enter Order Quantity: ");
                    qty = sc.nextInt();
                    warehouse.fulfillOrder(id, qty);
                    break;

                case 4:
                    warehouse.viewInventory();
                    break;

                case 5:
                    System.out.println(" Exiting System. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

