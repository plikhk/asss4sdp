package models;

public class Cart {
    private double totalAmount;
    public Cart(double totalAmount) { this.totalAmount = totalAmount; }
    public double getTotalAmount() { return totalAmount; }
}

public class Customer {
    private String name;
    private String email;
    public Customer(String name, String email) { this.name = name; this.email = email; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

public class Order {
    private String orderId;
    public Order(String orderId) { this.orderId = orderId; }
    public String getOrderId() { return orderId; }
}