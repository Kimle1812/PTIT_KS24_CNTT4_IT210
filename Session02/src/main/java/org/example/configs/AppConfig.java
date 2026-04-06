package org.example.ss02.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// đánh dấu lớp cấu hình
@Configuration
// bật sử dụng web mvc
@EnableWebMvc
// sử dụng scan để quét các bean
@ComponentScan(basePackages = "org.example.ss02")
public class AppConfig {

    // Phải cấu hình bean view dữ liệu
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // tiền tố
        viewResolver.setPrefix("/views/");
        // hậu tố
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
