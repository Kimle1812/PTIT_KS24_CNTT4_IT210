package org.example.homework03.implement;

import org.example.homework03.repository.InventoryRepository;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {
    private Map<String, Integer> stock = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();

    public InventoryRepositoryImpl() {
        stock.put("Mi xao bo", 5);
        stock.put("Mi tom", 10);
        prices.put("Mi xao bo", 30000.0);
        prices.put("Mi tom", 10000.0);
    }

    @Override
    public int getStock(String foodName) {
        return stock.getOrDefault(foodName, 0);
    }

    @Override
    public double getPrice(String foodName) {
        return prices.getOrDefault(foodName, 0.0);
    }

    @Override
    public void reduceStock(String foodName, int quantity) {
        stock.put(foodName, stock.get(foodName) - quantity);
    }
}