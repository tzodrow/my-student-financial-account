/**
 * 
 */
package edu.wisc.student.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web {@link Configuration}.
 * 
 * @author zodrow
 */
@Configuration
@EnableWebMvc
@ComponentScan("edu.wisc.student.web.rest")
public class WebConfiguration extends WebMvcConfigurerAdapter{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/docs/**").addResourceLocations("/docs/");
		registry.addResourceHandler("/*").addResourceLocations("/");
	}

}
