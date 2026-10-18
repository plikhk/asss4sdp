package client;

import facade.OrderFacade;
import models.Cart;
import models.Customer;
import models.Order;

public class Main {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();

        Customer customer = new Customer("John Doe", "john.doe@example.com");
        Cart cart = new Cart(150.50);

        try {
            Order myOrder = orderFacade.placeOrder(cart, customer);

            // Демонстрация отмены заказа
            orderFacade.cancelOrder(myOrder, customer);

        } catch (RuntimeException e) {
            System.err.println("Ошибка при оформлении: " + e.getMessage());
        }
    }
}