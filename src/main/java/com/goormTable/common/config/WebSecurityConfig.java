package com.goormTable.common.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrfConfigurer)->
                        csrfConfigurer.disable()
                )
                .authorizeHttpRequests((autorizeRequests) ->
                        autorizeRequests
                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers("/","/login/**").permitAll()
                                .requestMatchers("/user").hasRole(Role.USER.name())
                                .requestMatchers("/admin").hasRole(Role.ADMIN.name())
                                .anyRequest().authenticated()
                );
        return http.build();
    }
}