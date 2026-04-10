package org.example.session05.Exercise01;


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
@ComponentScan("org.example.session05.Exercise01")
public class AppConfig {

    // --- PHÁ ÁN LỖI KẾT XUẤT GIAO DIỆN ---
    // Điểm sai 1: Sai hậu tố (Suffix). Người cũ dùng .jsp cho cấu hình Thymeleaf là sai,
    // vì engine Thymeleaf chỉ đọc được các file template HTML.
    // Điểm sai 2: Thiếu dấu gạch chéo "/" ở cuối Prefix. Khi thiếu dấu này, Spring sẽ
    // tìm file kiểu "viewsnhanvien.html" thay vì vào thư mục "views/nhanvien.html".

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

        // Sửa lỗi Prefix: Thêm dấu / ở cuối để xác định đúng thư mục views
        resolver.setPrefix("/WEB-INF/views/");

        // Sửa lỗi Suffix: Đổi từ .jsp sang .html để khớp với công nghệ Thymeleaf
        resolver.setSuffix(".html");

        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
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