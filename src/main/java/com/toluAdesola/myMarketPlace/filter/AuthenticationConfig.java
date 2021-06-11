package com.toluAdesola.myMarketPlace.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationConfig {
    @Bean
    public FilterRegistrationBean<AuthenticationFilter> filterRegistrationBean() {
        FilterRegistrationBean <AuthenticationFilter> registrationBean = new FilterRegistrationBean();
        AuthenticationFilter invalidUserFilter = new AuthenticationFilter();
        registrationBean.setFilter(invalidUserFilter);
        registrationBean.addUrlPatterns("/admin/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
