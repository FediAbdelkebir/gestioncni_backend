package com.cni.security;
/*
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("postgres")
          .password("fedi")
          .roles("USER");
    }
 
    @Override
    protected void configure(HttpSecurity http) 
      throws Exception {
    	http.cors();
        http.csrf().disable()
          .authorizeRequests()
          .antMatchers("/register").permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
    }
}*/
