package com.e1858.building.config;

import com.e1858.building.common.constant.SecurityConstant;
import com.e1858.building.security.validate.tradition.VerifyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings(SecurityConstant.VALIDATE_CODE_PIC_URL);
        return registration;
    }
}
