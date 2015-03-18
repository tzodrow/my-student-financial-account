/**
 * 
 */
package edu.wisc.student.web.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import edu.wisc.student.finance.v1.ChargeType;

/**
 * Service {@link Configuration}.
 * 
 * @author zodrow
 */
@Configuration
@ComponentScan("edu.wisc.student.finance.demo")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(ChargeType.class);
		return marshaller;
	}
	/**
	 * This bean is required for {@link Value} annotations to be able to accept placeholders.
	 * 
	 * @return a {@link PropertySourcesPlaceholderConfigurer}
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}
}
