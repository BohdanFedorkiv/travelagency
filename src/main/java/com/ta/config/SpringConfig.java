package com.ta.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan("com.ta")
public class SpringConfig implements WebMvcConfigurer  {

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/pages/**").addResourceLocations("/pages/");
    }
}

/*
@Configuration – (для класса) говорит Spring, что это конфигурационный класс;

@EnableWebMvc – (для класса) указывает, что конфигурация поддерживает Web MVC;

@ComponentScan(“com.devcolibri.common”) – (для класса) говорим Spring-у в каком пакете
будут лежать controllers и сервисы для их инициализации.

@Bean – (для метода) – указывает, что аннотируемый метод является инициализацией бина требуемого
для выполнение вашей логики.

 */
