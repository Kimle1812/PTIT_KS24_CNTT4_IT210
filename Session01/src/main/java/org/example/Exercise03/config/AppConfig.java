
package org.example.homework03.configs;

import org.example.homework03.repository.InventoryRepository;
import org.example.homework03.implement.InventoryRepositoryImpl;
import org.example.homework03.repository.UserAccountRepository;
import org.example.homework03.implement.UserAccountRepositoryImpl;
import org.example.homework03.service.OrderFoodService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public InventoryRepository inventoryRepository() {
        return new InventoryRepositoryImpl();
    }

    @Bean
    public UserAccountRepository userAccountRepository() {
        return new UserAccountRepositoryImpl();
    }

    @Bean
    public OrderFoodService orderFoodService(InventoryRepository inventoryRepo,
                                             UserAccountRepository accountRepo) {
        return new OrderFoodService(inventoryRepo, accountRepo);
    }
}
