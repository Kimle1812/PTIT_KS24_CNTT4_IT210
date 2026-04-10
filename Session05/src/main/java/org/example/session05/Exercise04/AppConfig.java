package org.example.session05.Exercise04;


import nz.net.ultraq.thymeleaf.layout.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan("org.example.session05.Exercise04")
public class AppConfig {

    /* * ==============================================================================
     * BÀI 4: PHÂN TÍCH VÀ SO SÁNH CÁCH TIẾP CẬN LAYOUT
     * * 1. BẢNG SO SÁNH ƯU/NHƯỢC ĐIỂM:
     * ------------------------------------------------------------------------------
     * Tiêu chí        | (A) Copy-paste Mã nguồn       | (B) Layout:decorate (Dialect)
     * ------------------------------------------------------------------------------
     * Bảo trì         | Kém (Sửa 1 chỗ phải sửa n nơi)| Rất tốt (Sửa 1 nơi dùng n nơi)
     * Độ sạch của mã  | Tệ (Mã nguồn lặp lại nhiều)   | Tốt (Trang con cực kỳ gọn gàng)
     * Sự đồng nhất    | Thấp (Dễ quên, sai lệch UI)   | Tuyệt đối (Cấu trúc UI cố định)
     * Tốc độ code     | Nhanh lúc đầu, nản về sau     | Chậm lúc đầu, nhàn về sau
     * ------------------------------------------------------------------------------
     * * 2. GIẢI THÍCH KỸ THUẬT:
     * Tại sao phải đăng ký Bean LayoutDialect trong SpringTemplateEngine?
     * - Vì cú pháp 'layout:decorate' hay 'layout:fragment' không phải là tính năng
     * mặc định (core) của Thymeleaf.
     * - LayoutDialect là một thư viện mở rộng. Khi đăng ký Bean này, engine của
     * Thymeleaf mới được kích hoạt bộ xử lý để hiểu và "ghép" các mảnh layout
     * lại với nhau. Nếu thiếu, trình duyệt sẽ coi các thẻ layout: là rác.
     * ==============================================================================
     */

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());

        // ĐĂNG KÝ LAYOUT DIALECT TẠI ĐÂY ĐỂ BÀI 4 CHẠY ĐƯỢC
        engine.addDialect(new LayoutDialect());

        return engine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}