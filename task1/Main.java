import java.util.ArrayList;

// Клас "Товар"
class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Геттери для отримання властивостей товару
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Базовий клас "Замовлення"
class Order {
    private ArrayList<Product> products;
    private String customer;
    private String shippingAddress;
    private boolean paymentStatus;

    public Order(String customer, String shippingAddress) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.paymentStatus = false;
        this.products = new ArrayList<>();
    }

    // Додавання товару до замовлення
    public void addProduct(Product product) {
        products.add(product);
    }

    // Видалення товару з замовлення
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Зміна статусу оплати
    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Геттери для отримання властивостей замовлення
    public ArrayList<Product> getProducts() {
        return products;
    }

    public String getCustomer() {
        return customer;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }
}

// Приклад використання
public class Main {
    public static void main(String[] args) {
        // Створення замовлення
        Order order = new Order("John Doe", "123 Main St");

        // Додавання товарів до замовлення
        Product laptop = new Product("Laptop", 1200.00, 1);
        Product mouse = new Product("Wireless Mouse", 29.99, 2);

        order.addProduct(laptop);
        order.addProduct(mouse);

        // Виведення інформації про замовлення
        System.out.println("Customer: " + order.getCustomer());
        System.out.println("Shipping Address: " + order.getShippingAddress());
        System.out.println("Products:");

        for (Product product : order.getProducts()) {
            System.out.println("  - " + product.getName() + ", Price: $" + product.getPrice() +
                    ", Quantity: " + product.getQuantity());
        }

        // Зміна статусу оплати
        order.setPaymentStatus(true);
        System.out.println("Payment Status: " + order.getPaymentStatus());
    }
}
