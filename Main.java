package main;

import model.Product;
import service.Warehouse;
import service.AlertService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlertService alert = (product) -> {
            System.out.println("Restock Alert: " + product.getName() +
                               " is low on stock. Only " + product.getQuantity() + " left.");
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
            System.out.print("Enter your choice: ");

            int choice = getSafeInt(sc, "menu choice");

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter Product ID: ");
                    String id = sc.nextLine().trim();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter Initial Quantity: ");
                    int qty = getPositiveInt(sc, "initial quantity");

                    System.out.print("Enter Reorder Threshold: ");
                    int threshold = getPositiveInt(sc, "reorder threshold");

                    warehouse.addProduct(new Product(id, name, qty, threshold));
                   
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Product ID: ");
                    id = sc.nextLine().trim();

                    System.out.print("Enter Shipment Quantity: ");
                    qty = getPositiveInt(sc, "shipment quantity");

                    warehouse.receiveShipment(id, qty);
                    System.out.println("Shipment received successfully.");
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Product ID: ");
                    id = sc.nextLine().trim();

                    System.out.print("Enter Order Quantity: ");
                    qty = getPositiveInt(sc, "order quantity");

                    warehouse.fulfillOrder(id, qty);
                    System.out.println("Order processed successfully.");
                    break;

                case 4:
                    System.out.println("\n----------- INVENTORY LIST -----------");
                    warehouse.viewInventory();
                    System.out.println("--------------------------------------");
                    break;

                case 5:
                    System.out.println("Exiting System. Goodbye.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static int getSafeInt(Scanner sc, String fieldName) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input for " + fieldName + ". Please enter a valid number: ");
            }
        }
    }

    private static int getPositiveInt(Scanner sc, String fieldName) {
        int value;
        while (true) {
            value = getSafeInt(sc, fieldName);
            if (value >= 0) {
                return value;
            }
            System.out.print("Value for " + fieldName + " cannot be negative. Enter again: ");
        }
    }
}
