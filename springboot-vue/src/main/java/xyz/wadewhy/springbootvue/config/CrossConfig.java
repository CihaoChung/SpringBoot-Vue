package xyz.wadewhy.springbootvue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springbootvue.config
 * @NAME: CrossConfig
 * @Author: 钟子豪
 * @DATE: 2020/3/24
 * @MONTH_NAME_FULL: 三月
 * @DAY: 24
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: springboot-vue
 **/
@Configuration
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
