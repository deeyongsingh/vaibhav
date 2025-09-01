package InventoryManagementSystem;
import java.util.*;
public interface Restockable {
        void restock(int quantity);
    }

    abstract class Product implements Restockable {
        String id;
        String name;
        int stock;
        String expiryDate;

        public Product(String id, String name, int stock, String expiryDate) {
            this.id = id;
            this.name = name;
            this.stock = stock;
            this.expiryDate = expiryDate;
        }

        public void restock(int quantity) {
            stock += quantity;
        }

        public boolean isLowStock() {
            return stock < 5;
        }

        public String toString() {
            return getClass().getSimpleName() + " = " + "product Name-" + name + ", ID: " + id + " , Stock: " + stock + " , Exp: " + expiryDate;
        }
    }

    class Electronics extends Product {
        public Electronics(String id, String name, int stock, String expiryDate) {
            super(id, name, stock, expiryDate);
        }
    }

    class Clothing extends Product {
        public Clothing(String id, String name, int stock, String expiryDate) {
            super(id, name, stock, expiryDate);
        }
    }

    class Grocery extends Product {
        public Grocery(String id, String name, int stock, String expiryDate) {
            super(id, name, stock, expiryDate);
        }
    }

    class OutOfStockException extends Exception {
        public OutOfStockException(String message) {
            super(message);
        }
    }

    class InvalidProductException extends Exception {
        public InvalidProductException(String message) {
            super(message);
        }
    }

    class Supplier {
        String name;

        public Supplier(String name) {
            this.name = name;
        }

        public void orderProduct(Product product, int quantity) {
            System.out.println("Supplier '" + name + "' ordered " + quantity + " units of " + product.name);
        }
    }

    class Inventory {
        ArrayList<Product> products = new ArrayList<>();

        public void addProduct(Product p) {
            products.add(p);
            System.out.println("Added product: " + p);
        }

        public void removeProduct(String id) throws InvalidProductException {
            for (Product p : products) {
                if (p.id.equals(id)) {
                    products.remove(p);
                    System.out.println("Removed product: " + p.name);
                    return;
                }
            }
            throw new InvalidProductException("Product ID not found.");
        }

        public void showInventory() {
            if (products.isEmpty()) {
                System.out.println("Inventory is empty.");
                return;
            }

            for (Product p : products) {
                System.out.println(p);
                if (p.isLowStock()) {
                    System.out.println("Low stock alert for " + p.name);
                }
            }
        }

        public void restockLowItems(Supplier supplier) {
            for (Product p : products) {
                if (p.isLowStock()) {
                    supplier.orderProduct(p, 10);
                    p.restock(10);
                    System.out.println("Restocked " + p.name + " to " + p.stock + " units.");
                }
            }
        }
    }

    class inventoryMain {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Inventory inventory = new Inventory();
            Supplier supplier = new Supplier("FastSupplier");

            while (true) {
                System.out.println("\n-------Inventory Menu-------");
                System.out.println("1. Add Product");
                System.out.println("2. Remove Product");
                System.out.println("3. View Inventory");
                System.out.println("4. Restock Low Stock");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                try {
                    if (choice == 1) {
                        System.out.print("Enter type (Electronics/Clothes/Grocery): ");
                        String type = sc.nextLine();
                        System.out.print("Enter product ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter product name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter stock: ");
                        int stock = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter expiry date (YYYY-MM-DD): ");
                        String expiry = sc.nextLine();

                        Product p;
                        switch (type.toLowerCase()) {
                            case "electronics":
                                p = new Electronics(id, name, stock, expiry);
                                break;
                            case "clothes":
                                p = new Clothing(id, name, stock, expiry);
                                break;
                            case "grocery":
                                p = new Grocery(id, name, stock, expiry);
                                break;
                            default:
                                throw new InvalidProductException("Invalid product type.");
                        }

                        inventory.addProduct(p);
                    } else if (choice == 2) {
                        System.out.print("Enter product ID to remove: ");
                        String id = sc.nextLine();
                        inventory.removeProduct(id);
                    } else if (choice == 3) {
                        inventory.showInventory();
                    } else if (choice == 4) {
                        inventory.restockLowItems(supplier);
                    } else if (choice == 5) {
                        System.out.println("Exiting system.");
                        break;
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            sc.close();
        }
    }

