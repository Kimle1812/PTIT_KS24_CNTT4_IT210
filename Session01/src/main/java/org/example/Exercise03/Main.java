
package org.example.Exercise03;

import org.example.homework03.configs.AppConfig;
import org.example.homework03.service.OrderFoodService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderFoodService service = context.getBean(OrderFoodService.class);

        System.out.println(service.orderFood("user01", "Mi xao bo", 2));
        System.out.println(service.orderFood("user02", "Mi xao bo", 2));
        System.out.println(service.orderFood("user01", "Mi tom", 1));
    }
}
