package com.soses.hris.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.entity.AntMatcher;
import com.soses.hris.repository.AntMatcherRepository;
import com.soses.hris.repository.RoleHierarchyRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private AntMatcherRepository antMatcherRepo;
	
	private RoleHierarchyRepository roleHierarchyRepo;
	
	@Autowired
    public SecurityConfig(AntMatcherRepository antMatcherRepo, RoleHierarchyRepository roleHierarchyRepo) {
		super();
		this.antMatcherRepo = antMatcherRepo;
		this.roleHierarchyRepo = roleHierarchyRepo;
	}

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
	    List<com.soses.hris.entity.RoleHierarchy> rhList = roleHierarchyRepo.findAllByEndDateGreaterThanAndEffDateLessThanEqual(LocalDate.now(), LocalDate.now());	
	    if (!GeneralUtil.isListEmpty(rhList)) {
	    	StringBuilder hierarchy = new StringBuilder();
	    	for (com.soses.hris.entity.RoleHierarchy role : rhList) {
	    		if (role.getChildRole() != null && role.getParentRole() != null) {
	    			hierarchy.append(role.getParentRole().getFullRoleCode()).append(" > ").append(role.getChildRole().getFullRoleCode()).append(" \n");
	    		}
	    	}
	    	roleHierarchy.setHierarchy(hierarchy.toString());
	    }
	    return roleHierarchy;
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
        http
//        	.addFilter(null)
//        	.addFilterBefore(null, null)
        	.authorizeRequests()
        	.antMatchers("/favicon.ico").permitAll()
        	.antMatchers("/css/public/**").permitAll()
        	.antMatchers("/js/public/**").permitAll();
        	
        List<AntMatcher> matchers = antMatcherRepo.findAllByEndDateGreaterThanAndEffDateLessThanEqual(LocalDate.now(), LocalDate.now());
        for (AntMatcher matcher : matchers) {
        	http.authorizeRequests().antMatchers(matcher.getPath()).access(matcher.getRoleInfo());
        }
        
    	http
    		.authorizeRequests()
    		.anyRequest().authenticated()
        	.and().formLogin().loginPage("/login").permitAll()
        	.and().logout().permitAll()
        	;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
}
