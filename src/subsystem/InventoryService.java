package subsystem;

import models.Cart;

public class InventoryService {
    public boolean checkStock(Cart cart) {
        System.out.println("[Inventory] Проверка наличия товаров на складе...");
        return true;
    }

    public void reserveStock(Cart cart) {
        System.out.println("[Inventory] Товары зарезервированы.");
    }

    public void releaseStock(Cart cart) {
        System.out.println("[Inventory] Откат: Резерв товаров снят.");
    }
}