package org.example.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * PHẦN 1: PHÂN TÍCH LOGIC
 * * 1. Lỗi trong MyWebAppInitializer.java:
 * - Giải thích: Việc để mapping "/api/*" khiến DispatcherServlet chỉ tiếp nhận các request
 * bắt đầu bằng đường dẫn /api/. Khi người dùng truy cập /welcome, nó không khớp với
 * pattern này nên Tomcat trả về lỗi 404.
 * - DispatcherServlet đang nghe: Các URL có định dạng /api/*
 * * 2. Lỗi trong WebConfig.java:
 * - Hậu quả: @ComponentScan chỉ quét package "com.demo.service" nên Spring sẽ bỏ qua
 * việc khởi tạo các Bean trong package "com.demo.controller".
 * - Spring MVC tìm @Controller ở: com.demo.service (nhưng không có).
 * - Không tìm thấy ở: com.demo.controller (nơi chứa WelcomeController).
 * * 3. Tổng hợp:
 * - Nếu chỉ sửa lỗi 1 mà không sửa lỗi 2, ứng dụng VẪN KHÔNG CHẠY.
 * - Tại sao: Vì dù request đã gửi được đến DispatcherServlet, nhưng Spring không tìm thấy
 * bất kỳ Controller nào được đăng ký để xử lý đường dẫn /welcome, dẫn đến lỗi không tìm thấy handler.
 */

public class Main {

    /**
     * PHẦN 2: THỰC THI - FILE MYWEBAPPINITIALIZER.JAVA
     */
    public static class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return null;
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[] { WebConfig.class };
        }

        @Override
        protected String[] getServletMappings() {
            // SỬA: Thay "/api/*" bằng "/" để nhận diện mọi luồng request vào ứng dụng
            return new String[] { "/" };
        }
    }

    /**
     * PHẦN 2: THỰC THI - FILE WEBCONFIG.JAVA
     */
    @Configuration
    @EnableWebMvc
    // SỬA: Quét rộng ra package "com.demo" để tìm thấy cả Controller và Service
    @ComponentScan(basePackages = "com.demo")
    public static class WebConfig {

        @Bean
        public ViewResolver viewResolver() {
            InternalResourceViewResolver bean = new InternalResourceViewResolver();

            // SỬA: Thiết lập đúng prefix và suffix để Spring tìm thấy file welcome.jsp
            bean.setPrefix("/WEB-INF/views/");
            bean.setSuffix(".jsp");

            return bean;
        }
    }
}