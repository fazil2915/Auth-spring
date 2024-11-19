package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFilter {
    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http)throws  Exception{

    return http
            .csrf(customizer->customizer.disable())
            .authorizeHttpRequests(request->request.anyRequest().authenticated())
           //http.formLogin(Customizer.withDefaults());
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

    .build();
}

}
