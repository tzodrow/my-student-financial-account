package edu.wisc.student.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfiguration {

    @Autowired
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("api/**").authenticated();
    }

}
