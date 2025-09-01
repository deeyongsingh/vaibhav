package Inventorymanagementsystem;
import java.util.*;
interface Restockable {
    void restock(int quantity);
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
abstract class Product implements Restockable {
    String name;
    int stock;
    String expiryDate;

    public Product(String name, int stock, String expiryDate) {
        this.name = name;
        this.stock = stock;
        this.expiryDate = expiryDate;
    }

    abstract void displayInfo();

    public boolean isLowStock() {
        return stock < 5;
    }

    public void restock(int quantity) {
        stock += quantity;
        System.out.println(name + " को फिर से स्टॉक किया गया: अब स्टॉक = " + stock);
    }

    public void reduceStock(int quantity) throws OutOfStockException {
        if (stock < quantity) throw new OutOfStockException(name + " का स्टॉक पूरा नहीं है!");
        stock -= quantity;
    }
}
class Electronics extends Product {
    public Electronics(String name, int stock, String expiryDate) {
        super(name, stock, expiryDate);
    }
    void displayInfo() {
        System.out.println("Electronics: " + name + ", Stock: " + stock + ", Expiry: " + expiryDate);
    }
}

class Clothing extends Product {
    public Clothing(String name, int stock, String expiryDate) {
        super(name, stock, expiryDate);
    }
    void displayInfo() {
        System.out.println("Clothing: " + name + ", Stock: " + stock + ", Expiry: " + expiryDate);
    }
}

class Grocery extends Product {
    public Grocery(String name, int stock, String expiryDate) {
        super(name, stock, expiryDate);
    }
    void displayInfo() {
        System.out.println("Grocery: " + name + ", Stock: " + stock + ", Expiry: " + expiryDate);
    }
}
class Inventory {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println(p.name + " इन्वेंट्री में जोड़ा गया।");
    }

    public void removeProduct(String name) throws InvalidProductException {
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                products.remove(p);
                System.out.println(name + " को हटाया गया।");
                return;
            }
        }
        throw new InvalidProductException("❌ " + name + " इन्वेंट्री में नहीं है।");
    }

    public void checkLowStock() {
        for (Product p : products) {
            if (p.isLowStock()) {
                System.out.println("⚠ लो स्टॉक अलर्ट: " + p.name);
            }
        }
    }
    public void showInventory() {
        for (Product p : products) {
            p.displayInfo();
        }
    }

    public Product getProductByName(String name) throws InvalidProductException {
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) return p;
        }
        throw new InvalidProductException("❌ " + name + " नहीं मिला।");
    }
}
class Supplier {
    public void orderStock(Product p, int quantity) {
        p.restock(quantity);
        System.out.println("📦 सप्लायर ने " + quantity + " items भेजे for " + p.name);
    }
}
class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Supplier supplier = new Supplier();

        // प्रोडक्ट्स जोड़ना
        Product laptop = new Electronics("Laptop", 3, "2030-12-31");
        Product jeans = new Clothing("Jeans", 7, "2028-06-15");
        Product milk = new Grocery("Milk", 2, "2025-10-10");

        inventory.addProduct(laptop);
        inventory.addProduct(jeans);
        inventory.addProduct(milk);

        // इन्वेंट्री दिखाना
        System.out.println("\n📋 इन्वेंट्री लिस्ट:");
        inventory.showInventory();

        // लो स्टॉक चेक करना
        System.out.println("\n🔍 लो स्टॉक चेक:");
        inventory.checkLowStock();

        // सप्लायर से स्टॉक मंगवाना
        supplier.orderStock(milk, 10);

        // किसी प्रोडक्ट को हटाना
        try {
            inventory.removeProduct("Jeans");
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        }

        // प्रोडक्ट बेचने की कोशिश
        try {
            Product p = inventory.getProductByName("Laptop");
            p.reduceStock(4); // ज़्यादा मांगने पर exception आएगा
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        // फाइनल इन्वेंट्री
        System.out.println("\n📋 फाइनल इन्वेंट्री:");
        inventory.showInventory();
    }
}

