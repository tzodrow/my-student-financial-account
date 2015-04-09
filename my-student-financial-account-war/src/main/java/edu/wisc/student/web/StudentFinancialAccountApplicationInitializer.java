/**
 *
 */
package edu.wisc.student.web;

import edu.wisc.student.web.configuration.ApplicationSecurityConfiguration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import edu.wisc.student.web.configuration.ApplicationConfiguration;
import edu.wisc.student.web.configuration.WebConfiguration;
import edu.wisc.student.web.configuration.WebSecurityConfiguration;
import edu.wisc.uwss.configuration.UWSpringSecurityConfiguration;

/**
 * Servlet 3.0 initializer.
 *
 * @author zodrow
 */
public class StudentFinancialAccountApplicationInitializer extends
	AbstractAnnotationConfigDispatcherServletInitializer {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {
				ApplicationConfiguration.class, 
				ApplicationSecurityConfiguration.class,
				UWSpringSecurityConfiguration.class,
				WebConfiguration.class,
				WebSecurityConfiguration.class
		};
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfiguration.class };
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/api/*" };
	}

}