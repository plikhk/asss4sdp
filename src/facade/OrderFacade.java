package facade;

import models.Cart;
import models.Customer;
import models.Order;
import subsystem.InventoryService;
import subsystem.NotificationService;
import subsystem.PaymentProcessor;
import subsystem.ShippingService;

import java.util.UUID;

public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentProcessor = new PaymentProcessor();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public Order placeOrder(Cart cart, Customer customer) {
        System.out.println("\n--- Начинается оформление заказа ---");

        if (!inventoryService.checkStock(cart)) {
            throw new RuntimeException("Извините, некоторых товаров нет на складе.");
        }

        inventoryService.reserveStock(cart);

        boolean isPaid = paymentProcessor.processPayment(customer, cart.getTotalAmount());
        if (!isPaid) {
            inventoryService.releaseStock(cart); // Rollback
            throw new RuntimeException("Оплата отклонена. Заказ отменен.");
        }

        Order order = new Order(UUID.randomUUID().toString().substring(0, 8));

        shippingService.arrangeShipping(order);
        notificationService.sendOrderConfirmation(customer, order);

        System.out.println("--- Заказ успешно оформлен! ---\n");
        return order;
    }

    public void cancelOrder(Order order, Customer customer) {
        System.out.println("\n--- Начинается отмена заказа " + order.getOrderId() + " ---");

        shippingService.cancelShipping(order.getOrderId());
        paymentProcessor.refundPayment(order.getOrderId());
        notificationService.sendCancellation(customer, order.getOrderId());

        System.out.println("--- Заказ успешно отменен ---\n");
    }
}