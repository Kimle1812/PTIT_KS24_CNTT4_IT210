// Quy tắc đặt tên package là snake_case
package org.example.configs;

import org.example.Person;
import org.springframework.context.annotation.Bean;

// QUy tắc đặt tên của Class --> PascalCase

public class AppConfiguration {

    @Bean
    public Person fullstack() {
        // Quy tắc đặt tên của biến camelCase
        Person hoangThaiMinh = new Person();
        hoangThaiMinh.setId(1);
        hoangThaiMinh.setName("Hoàng Thái Minh");
        hoangThaiMinh.setMajor("Full stack");
        return hoangThaiMinh;
    }

}