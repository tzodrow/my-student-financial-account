package edu.wisc.student.web.configuration;

import java.util.Arrays;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import edu.wisc.student.finance.security.StudentFinancialAccountPermissionEvaluator;

/**
 * {@link Configuration} enabling Spring Security's Web integration.
 * 
 * See {@link ApplicationSecurityConfiguration} for the service layer configuration.
 * 
 * @author Nicholas Blair
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	static final Logger logger = LoggerFactory.getLogger(WebSecurityConfiguration.class);
	
	@Inject
	private Environment environment;
		
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	logger.info("configuring HttpSecurity, activeProfiles={}", Arrays.toString(environment.getActiveProfiles()));
        http
        	.authorizeRequests()
        		.antMatchers(HttpMethod.GET, "/docs/**").permitAll()
	        	.antMatchers(HttpMethod.GET, "/api-docs/**").permitAll()
	        	.antMatchers(HttpMethod.GET, "/js/**").permitAll()
        		.antMatchers("api/v1/charges/**").hasAuthority(StudentFinancialAccountPermissionEvaluator.VIEW_CHARGES)
        		.anyRequest().authenticated()
        		.and()
        	.formLogin()
        		.and()
		    .httpBasic()
		    	.and()
		    .logout()
		    	.deleteCookies("JSESSIONID")
		    	.invalidateHttpSession(true);
    }

}
