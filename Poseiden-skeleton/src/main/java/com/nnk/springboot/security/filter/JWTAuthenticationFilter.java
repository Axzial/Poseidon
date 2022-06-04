package com.nnk.springboot.security.filter;

import com.nnk.springboot.security.entity.JwtAuthenticationToken;
import com.nnk.springboot.security.utils.JwtUtils;
import com.nnk.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Filter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Filter(name = "jwtAuthenticationFilter")
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authentication");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        UserDetails userDetails = userService.loadUserByUsername(JwtUtils.getUsernameFromToken(token));
        // TODO Exception
        if (!JwtUtils.validateToken(token, userDetails)) throw new RuntimeException("Invalid token");
        Authentication authentication = new JwtAuthenticationToken(token);
        authenticationManager.authenticate(authentication);
        filterChain.doFilter(request, response);
    }
}