
package org.example.homework03.service;

import org.example.homework03.repository.InventoryRepository;
import org.example.homework03.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFoodService {
    private final InventoryRepository inventoryRepo;
    private final UserAccountRepository accountRepo;

    @Autowired
    public OrderFoodService(InventoryRepository inventoryRepo,
                            UserAccountRepository accountRepo) {
        this.inventoryRepo = inventoryRepo;
        this.accountRepo = accountRepo;
    }

    public String orderFood(String userId, String foodName, int quantity) {
        int stock = inventoryRepo.getStock(foodName);
        if (stock < quantity) {
            return "Xin loi ban, mon " + foodName + " da het";
        }

        double price = inventoryRepo.getPrice(foodName) * quantity;
        double balance = accountRepo.getBalance(userId);

        if (balance < price) {
            return "Tai khoan khong du tien ban eiiiii";
        }

        inventoryRepo.reduceStock(foodName, quantity);
        accountRepo.deductBalance(userId, price);
        return "Dat mon thanh cong: " + foodName + " x" + quantity;
    }
}
