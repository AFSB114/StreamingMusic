package com.sena.basic_crud.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiKeyFilter extends OncePerRequestFilter {

    private final String apiKeyHeader;
    private final String apiKeyValue;

    public ApiKeyFilter(String apiKeyHeader, String apiKeyValue) {
        this.apiKeyHeader = apiKeyHeader;
        this.apiKeyValue = apiKeyValue;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // No aplicar verificación para OPTIONS (preflight requests)
        if (!request.getMethod().equals("OPTIONS")) {
            String apiKey = request.getHeader(apiKeyHeader);

            if (apiKey == null || !apiKey.equals(apiKeyValue)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("API key inválida o falta");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}