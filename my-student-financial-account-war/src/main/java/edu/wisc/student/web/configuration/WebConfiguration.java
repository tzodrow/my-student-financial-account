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
 * @author zodrow
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("edu.wisc.student.web.rest")
public class WebConfiguration extends WebMvcConfigurerAdapter{
	/**
	 * Add resource handlers for static resources like /webjars/** (for swagger-ui).
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		/*registry.addResourceHandler("/docs/**").addResourceLocations("/docs/");
		
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/edu.wisc.uc/**").addResourceLocations("classpath:/META-INF/resources/edu.wisc.uc/");
		
		registry.addResourceHandler("/*").addResourceLocations("/");*/
	}
}
