package models;

public class Cart {
    private double totalAmount;

    public Cart(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}