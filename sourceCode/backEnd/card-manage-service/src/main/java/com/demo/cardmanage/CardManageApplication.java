package com.demo.cardmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.demo.cardmanage.filter.SimpleCorsFilter;

@SpringBootApplication
public class CardManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardManageApplication.class, args);
	}
	
	@Bean
    public FilterRegistrationBean<SimpleCorsFilter> simpleCorsFilterRegist() {
        FilterRegistrationBean<SimpleCorsFilter> registration = new FilterRegistrationBean<SimpleCorsFilter>();
        registration.setFilter(new SimpleCorsFilter("*",
                "GET,POST,PUT,DELETE,OPTIONS",
                "true",
                "Cache-Control,Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers, Last-Modified,X-Auth-Token,project_id,project_name,domain_id,domain_name,Pragma,X-Register-Code",
                "Captcha-ID,Content-Disposition",
                "3600",
                null
        ));
        registration.addUrlPatterns("/*");
        registration.setOrder(2);
        return registration;
    }
	
}
