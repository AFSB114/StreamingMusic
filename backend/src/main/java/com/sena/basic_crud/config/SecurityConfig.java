package com.sena.basic_crud.config;

import com.sena.basic_crud.jwt.JwtAuthFilter;
import com.sena.basic_crud.model.Token;
import com.sena.basic_crud.repository.IToken;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthFilter jwtAuthFilter;
    private final IToken tokenRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
        System.out.print("Security Filter Chain");
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**","/api/v1/auth/recovery-pass").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler((request, response, authentication) -> {
                                    final var authHeader = request.getHeader("Authorization");
                                    logout(authHeader);
                                })
                                .logoutSuccessHandler(((request, response, authentication) ->
                                        SecurityContextHolder.clearContext())
                                )
                )
                 //.httpBasic(Customizer.withDefaults()) // o .formLogin() si usas login por formulario
                .build();
    }

    private void logout(String token) {
        if (token == null || !token.startsWith("Bearer ")) throw  new IllegalArgumentException("Invalid Token");

        String jwtToken =  token.substring(7);
        Token foundToken = tokenRepository.findByToken(jwtToken).orElseThrow(()-> new IllegalArgumentException("Invalid Token"));

        foundToken.setExpired(true);
        foundToken.setLocked(true);
        tokenRepository.save(foundToken);
    }
}
