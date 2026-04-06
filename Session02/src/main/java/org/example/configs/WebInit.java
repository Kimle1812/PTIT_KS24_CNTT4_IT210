package org.example.ss02.configs;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        // Liệt những lớp cấu hình ở đây
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // tất cả những request đều sẽ đi qua đây
        return new String[]{"/"};
    }
}
