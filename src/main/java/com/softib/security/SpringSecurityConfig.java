package com.softib.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;






@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailsService userDetailsService ;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(userDetailsService);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        .antMatchers("/api/rest/auth",
        			"/api/rest/register",
        			"/api/rest/v2/api-docs",
        			"/api/rest//configuration/**",
        			"/api/rest/swagger*/**",
        			"/api/rest/swagger-resources/**",
        			"/api/rest/configuration/security",
        			"/api/rest/swagger-ui.html",
        			"/api/rest/webjars/**").permitAll()
        .and().authorizeRequests().antMatchers("/api/rest/users").hasAnyAuthority("ADMIN")
        .anyRequest().authenticated()
        .and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();    
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	return super.authenticationManager();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}