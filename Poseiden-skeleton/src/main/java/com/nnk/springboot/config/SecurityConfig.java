package com.nnk.springboot.config;

import com.nnk.springboot.config.security.filter.JWTAuthenticationFilter;
import com.nnk.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .formLogin()
                .loginPage("/login")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        http.antMatcher("/api/**").addFilterBefore(new JWTAuthenticationFilter(userService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
