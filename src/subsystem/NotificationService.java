package subsystem;

import models.Customer;
import models.Order;

public class NotificationService {
    public void sendOrderConfirmation(Customer customer, Order order) {
        System.out.println("[Notification] Отправка email на " + customer.getEmail() + ": Ваш заказ " + order.getOrderId() + " оформлен.");
    }

    public void sendCancellation(Customer customer, String orderId) {
        System.out.println("[Notification] Отправка email на " + customer.getEmail() + ": Ваш заказ " + orderId + " отменен.");
    }
}