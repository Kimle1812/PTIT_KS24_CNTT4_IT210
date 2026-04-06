package org.example.Exercise03.repository;

public interface InventoryRepository {
    int getStock(String foodName);
    double getPrice(String foodName);
    void reduceStock(String foodName, int quantity);
}