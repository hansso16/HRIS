package com.soses.hris.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.soses.hris.auth.UserDetailsServiceImp;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	private final String ENCODED_PASSWORD = passwordEncoder().encode("test123");
	
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImp();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public RoleHierarchy roleHierarchy() {
	    RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
	    String hierarchy = "ROLE_ADMIN > ROLE_MANAGER \n"
	    				+ " ROLE_MANAGER > ROLE_SUPV \n"
	    				+ " ROLE_SUPV > ROLE_EMPLOYEE"
	    				;
	    roleHierarchy.setHierarchy(hierarchy);
	    return roleHierarchy;
	}
	
//	@Bean
//	public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
//	    DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
//	    expressionHandler.setRoleHierarchy(roleHierarchy());
//	    return expressionHandler;
//	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//        	.addFilter(null)
//        	.addFilterBefore(null, null)
        	.authorizeRequests()
        	.antMatchers("/favicon.ico").permitAll()
        	.antMatchers("/css/public/**").permitAll()
        	.antMatchers("/js/public/**").permitAll()
        	.anyRequest().authenticated()
        	.and().formLogin().loginPage("/login").permitAll()
        	//.loginProcessUrl("/authenticate").permitAll()
        	.and().logout().permitAll()
        	;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider());
		
//		auth.inMemoryAuthentication()
//			.passwordEncoder(passwordEncoder())
//			.withUser("john").password(ENCODED_PASSWORD).roles("EMPLOYEE")
//			.and().withUser("mary").password(ENCODED_PASSWORD).roles("MANAGER")
//			.and().withUser("foo").password(ENCODED_PASSWORD).roles("ADMIN");
		
	}
}
