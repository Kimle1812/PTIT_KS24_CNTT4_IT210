package org.example.Exercise03.repository;

public interface UserAccountRepository {
    double getBalance(String userId);
    void deductBalance(String userId, double amount);
}