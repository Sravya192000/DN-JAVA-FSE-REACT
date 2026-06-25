import java.util.HashMap;

class Product {

    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName,
            int quantity, double price) {

        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return "ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: " + price;
    }
}

class InventoryManager {

    HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product

    public void addProduct(Product product) {

        inventory.put(product.getProductId(),
                product);

        System.out.println("Product Added");
    }

    // Update Product

    public void updateProduct(int id,
            String name,
            int quantity,
            double price) {

        Product product = inventory.get(id);

        if (product != null) {

            product.setProductName(name);

            product.setQuantity(quantity);

            product.setPrice(price);

            System.out.println("Product Updated");
        }

        else {

            System.out.println("Product Not Found");
        }
    }

    // Delete Product

    public void deleteProduct(int id) {

        if (inventory.remove(id) != null) {

            System.out.println("Product Deleted");
        }

        else {

            System.out.println("Product Not Found");
        }
    }

    // Display Inventory

    public void displayInventory() {

        for (Product p : inventory.values()) {

            System.out.println(p);
        }
    }
}

public class inventory {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        // Add Products

        manager.addProduct(
                new Product(101,
                        "Laptop",
                        20,
                        50000));

        manager.addProduct(
                new Product(102,
                        "Mouse",
                        50,
                        500));

        manager.addProduct(
                new Product(103,
                        "Keyboard",
                        30,
                        1200));

        System.out.println("\nInventory:");

        manager.displayInventory();

        // Update Product

        manager.updateProduct(
                102,
                "Wireless Mouse",
                60,
                700);

        // Delete Product

        manager.deleteProduct(103);

        System.out.println("\nUpdated Inventory:");

        manager.displayInventory();
    }
}