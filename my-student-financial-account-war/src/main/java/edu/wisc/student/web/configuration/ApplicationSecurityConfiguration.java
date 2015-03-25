/**
 * 
 */
package edu.wisc.student.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * {@link Configuration} activating security and access control components.
 * 
 * @author Nicholas Blair
 */
@Configuration
@ComponentScan("edu.wisc.student.finance.security")
@EnableGlobalMethodSecurity(prePostEnabled=true, jsr250Enabled=true)
public class ApplicationSecurityConfiguration {

}
