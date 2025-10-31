package main;

import model.Product;
import service.Warehouse;
import service.AlertService;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlertService alert = p -> System.out.println("Low stock alert: " + p.getName() + " | Qty: " + p.getQuantity());

        Map<String, Warehouse> warehouses = new HashMap<>();

        while (true) {
            System.out.println("\n===== INVENTORY MANAGEMENT =====");
            System.out.println("1. Create Warehouse");
            System.out.println("2. Select Warehouse");
            System.out.println("3. View All Warehouses");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = getSafeInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter Warehouse Name: ");
                    String name = sc.next().trim();
                    if (warehouses.containsKey(name)) {
                        System.out.println("Warehouse already exists");
                    } else {
                        warehouses.put(name, new Warehouse(name, alert));
                        System.out.println("Warehouse created: " + name);
                    }
                    break;

                case 2:
                    if (warehouses.isEmpty()) {
                        System.out.println("No warehouses created yet");
                        break;
                    }
                    System.out.print("Enter Warehouse Name: ");
                    String select = sc.next().trim();
                    Warehouse w = warehouses.get(select);
                    if (w == null) {
                        System.out.println("Warehouse not found");
                    } else {
                        warehouseMenu(sc, w);
                    }
                    break;

                case 3:
                    if (warehouses.isEmpty()) {
                        System.out.println("No warehouses available");
                    } else {
                        System.out.println("\nWarehouses:");
                        for (String wh : warehouses.keySet()) System.out.println("- " + wh);
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void warehouseMenu(Scanner sc, Warehouse w) {
        while (true) {
            System.out.println("\n--- " + w.getName() + " Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Receive Shipment");
            System.out.println("3. Fulfill Order");
            System.out.println("4. View Inventory");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            int ch = getSafeInt(sc);

            switch (ch) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String id = sc.next().trim();
                    System.out.print("Enter Name: ");
                    String pname = sc.next().trim();
                    System.out.print("Enter Quantity: ");
                    int q = getSafeInt(sc);
                    System.out.print("Enter Reorder Threshold: ");
                    int t = getSafeInt(sc);
                    w.addProduct(new Product(id, pname, q, t));
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    id = sc.next().trim();
                    System.out.print("Enter Shipment Quantity: ");
                    q = getSafeInt(sc);
                    w.receiveShipment(id, q);
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    id = sc.next().trim();
                    System.out.print("Enter Order Quantity: ");
                    q = getSafeInt(sc);
                    w.fulfillOrder(id, q);
                    break;

                case 4:
                    w.viewInventory();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static int getSafeInt(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
