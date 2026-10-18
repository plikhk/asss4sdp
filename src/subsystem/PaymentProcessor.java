package subsystem;

import models.Customer;

public class PaymentProcessor {
    public boolean processPayment(Customer customer, double amount) {
        System.out.println("[Payment] Обработка платежа на сумму $" + amount + " для " + customer.getName());
        // Возвращает true, если оплата успешна. Если поставить false, сработает rollback в Фасаде.
        return true;
    }

    public void refundPayment(String orderId) {
        System.out.println("[Payment] Возврат средств по заказу: " + orderId);
    }
}