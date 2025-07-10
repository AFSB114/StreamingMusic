package com.sena.basic_crud.jwt;

import com.sena.basic_crud.model.User;
import com.sena.basic_crud.model.Validation;
import com.sena.basic_crud.repository.IRecoveryRequest;
import com.sena.basic_crud.repository.IToken;
import com.sena.basic_crud.repository.IUser;
import com.sena.basic_crud.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final IToken tokenRepository;
    private final IUser userRepository;
    private final IRecoveryRequest recoveryRequestRepository;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.equals("/api/v1/auth")) {
            System.out.println("Path: " + path);
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("Invalid Token 1");
            filterChain.doFilter(request, response);
            return;
        }

        String jwtToken = authHeader.replace("Bearer ", "");
        String userEmail = jwtService.extractUserEmail(jwtToken);
        if (userEmail == null || SecurityContextHolder.getContext().getAuthentication() != null) {
            System.out.println("Invalid Token 2");
            return;
        }

        String typeToken = jwtService.extractTypeToken(jwtToken);
        Validation token = switch (typeToken) {
            case "access_token" -> tokenRepository.findByToken(jwtToken).orElse(null);
            case "recovery_pass_token" -> recoveryRequestRepository.findByToken(jwtToken).orElse(null);
            default -> null;
        };

        if (token == null || token.isExpired() || token.isLocked()) {
            System.out.println("Invalid Token 3");
            filterChain.doFilter(request, response);
            return;
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());
        if (user.isEmpty()) {
            System.out.println("Invalid Token 4");
            filterChain.doFilter(request, response);
            return;
        }

        boolean isTokenValid = jwtService.isTokenValid(jwtToken,  user.get());
        if (!isTokenValid) {
            System.out.println("Invalid Token 5");
            return;
        }

        var authToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        System.out.println("User: " + userDetails.getUsername());
        filterChain.doFilter(request, response);
    }
}
