
package org.example.homework03.implement;

import org.example.homework03.repository.UserAccountRepository;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {
    private Map<String, Double> balances = new HashMap<>();

    public UserAccountRepositoryImpl() {
        balances.put("user01", 100000.0);
        balances.put("user02", 20000.0);
    }

    @Override
    public double getBalance(String userId) {
        return balances.getOrDefault(userId, 0.0);
    }

    @Override
    public void deductBalance(String userId, double amount) {
        balances.put(userId, balances.get(userId) - amount);
    }
}
