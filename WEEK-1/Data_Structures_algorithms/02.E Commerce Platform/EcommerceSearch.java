import java.util.Arrays;
import java.util.Comparator;

class Product {

    int productId;
    String productName;
    String category;

    Product(int productId,
            String productName,
            String category) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {

        return "ID: " + productId +
                ", Name: " + productName +
                ", Category: " + category;
    }
}

public class EcommerceSearch {

    // Linear Search

    public static Product linearSearch(Product[] products,
            int targetId) {

        for (Product p : products) {

            if (p.productId == targetId) {

                return p;
            }
        }

        return null;
    }

    // Binary Search

    public static Product binarySearch(Product[] products,
            int targetId) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (products[mid].productId == targetId) {

                return products[mid];
            }

            else if (products[mid].productId < targetId) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {

                new Product(
                        103,
                        "Laptop",
                        "Electronics"),

                new Product(
                        101,
                        "Mouse",
                        "Accessories"),

                new Product(
                        104,
                        "Keyboard",
                        "Accessories"),

                new Product(
                        102,
                        "Phone",
                        "Electronics")
        };

        // Linear Search

        int searchId = 102;

        Product result1 = linearSearch(products,
                searchId);

        System.out.println(
                "Linear Search:");

        if (result1 != null) {

            System.out.println(result1);
        }

        else {

            System.out.println(
                    "Product Not Found");
        }

        // Sort Array for Binary Search

        Arrays.sort(products,
                Comparator.comparingInt(
                        p -> p.productId));

        Product result2 = binarySearch(products,
                searchId);

        System.out.println(
                "\nBinary Search:");

        if (result2 != null) {

            System.out.println(result2);
        }

        else {

            System.out.println(
                    "Product Not Found");
        }
    }
}