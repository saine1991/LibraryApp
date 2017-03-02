package com.skimina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.skimina.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final int PASSWORD_STRENGHT = 10;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication().withUser("admin@gmail.com").password("password").roles("ADMIN");
    	
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder(PASSWORD_STRENGHT));

    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()        
                    .antMatchers("/login").permitAll()
                    .antMatchers("/register").permitAll()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/users/**", "/create-user").hasRole("ADMIN")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/api/**").permitAll()
                    .antMatchers("/**").authenticated()
                .and()
                .formLogin()              
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginPage("/login")
                    .loginProcessingUrl("/login")       
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")  
                .and()
                .csrf().disable();             
    }
}
