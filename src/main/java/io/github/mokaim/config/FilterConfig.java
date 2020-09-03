package io.github.mokaim.config;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilterConfig implements WebMvcConfigurer {

    // Naver Lucy XSS Filter bean 등록
    @Bean
    public FilterRegistrationBean<XssEscapeServletFilter> getFilterRegistraionBean() {
        FilterRegistrationBean<XssEscapeServletFilter> registraionBean = new FilterRegistrationBean<XssEscapeServletFilter>();
        registraionBean.setFilter(new XssEscapeServletFilter());
        registraionBean.setOrder(1);
        registraionBean.addUrlPatterns("/*");

        return registraionBean;
    }

    //출저 : https://blog.naver.com/gomsun12/222054269345
}
