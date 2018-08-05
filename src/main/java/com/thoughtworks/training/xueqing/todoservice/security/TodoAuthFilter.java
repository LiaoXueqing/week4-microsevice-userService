package com.thoughtworks.training.xueqing.todoservice.security;

import com.google.common.net.HttpHeaders;
import com.thoughtworks.training.xueqing.todoservice.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class TodoAuthFilter extends OncePerRequestFilter {
    @Autowired
    private UserService userService;

    @Value("${secretkey}")
    private String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        request.getHeader(HttpHeaders.AUTHORIZATION);

        if (!StringUtils.isEmpty(token)) {
            try {
                String name = (String) Jwts.parser()
                        .setSigningKey(secretKey.getBytes())
                        .parseClaimsJws(token).getBody().get("name");

                SecurityContextHolder.getContext()
                        .setAuthentication(
                                new UsernamePasswordAuthenticationToken(name,
                                        null,
                                        Collections.emptyList()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        filterChain.doFilter(request, response);
    }
}

