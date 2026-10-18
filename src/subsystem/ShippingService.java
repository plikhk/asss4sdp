package subsystem;

import models.Order;

public class ShippingService {
    public void arrangeShipping(Order order) {
        System.out.println("[Shipping] Организация доставки для заказа " + order.getOrderId());
    }

    public void cancelShipping(String orderId) {
        System.out.println("[Shipping] Отмена доставки для заказа " + orderId);
    }
}