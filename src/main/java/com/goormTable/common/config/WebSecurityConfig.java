package com.goormTable.common.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrfConfigurer)->
                        csrfConfigurer.disable()
                )
                .authorizeHttpRequests((autorizeRequests) ->
                        autorizeRequests
                                .requestMatchers("/","/index.html","/login/**").permitAll()
                                //TODO swagger-ui 경로는 마스터계정(개발자)만 들어갈수 있도록 처리 필요
                                .requestMatchers("/swagger-ui/**","/swagger-ui.html", "/v3/api-docs/**", "/swagger-resources/**").permitAll()
                                .requestMatchers("/user").hasRole(Role.USER.name())
                                .requestMatchers("/admin").hasRole(Role.ADMIN.name())
                                .anyRequest().authenticated()
                );
        return http.build();
    }
}