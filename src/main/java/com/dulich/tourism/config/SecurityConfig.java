package com.dulich.tourism.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/my-wallet/withdraw","/my-wallet/top-up"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**","/login").permitAll()
                        .requestMatchers("/profile")
                        .hasRole("Customer")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("email")
                        .permitAll())
                .logout(config -> config
                        .logoutSuccessUrl("/").permitAll())
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();
    }
}
