package edu.wisc.student.web.configuration;

import java.io.IOException;
import java.util.Arrays;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import edu.wisc.student.finance.security.StudentFinancialAccountPermissionEvaluator;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;

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
	public static final String CSRF_HEADER = "X-XSRF-TOKEN";
	public static final String CSRF_COOKIE = "XSRF-TOKEN";
	public static final String SESSION_COOKIE = "JSESSIONID";

	@Inject
	private Environment environment;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		logger.info("configuring HttpSecurity, activeProfiles={}", Arrays.toString(environment.getActiveProfiles()));
		http
			.csrf()
				.csrfTokenRepository(buildCsrfTokenRepository())
				.and()
			.addFilterAfter(buildCsrfFilter(), CsrfFilter.class)
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
				.deleteCookies(SESSION_COOKIE, CSRF_COOKIE)
				.invalidateHttpSession(true);
	}

	private static HttpSessionCsrfTokenRepository buildCsrfTokenRepository() {
		HttpSessionCsrfTokenRepository tokenRepository = new HttpSessionCsrfTokenRepository();
		tokenRepository.setHeaderName(CSRF_HEADER);
		return tokenRepository;
	}

	/**
	 * Filter to create the XSRF-TOKEN cookie that Angular.js expects.  By doing this on the server side, Angular "just works",
	 * however, Spring does not use a cookie by default due to a known exploit:
	 * http://lists.webappsec.org/pipermail/websecurity_lists.webappsec.org/2011-February/007533.html
	 * TODO: This approach should be reviewed to determine whether this is still a relevant threat.
	 */
	private static Filter buildCsrfFilter() {
		return new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
				CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
				if (csrf != null) {
					Cookie cookie = new Cookie(CSRF_COOKIE, csrf.getToken());
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				filterChain.doFilter(request, response);
			}
		};
	}

}
