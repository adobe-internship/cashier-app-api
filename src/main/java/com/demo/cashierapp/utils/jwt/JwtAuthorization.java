package com.demo.cashierapp.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthorization extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = (request).getHeader("authorization");

        if (jwtToken == null || jwtToken.equals("undefined")) {
            filterChain.doFilter(request, response);
        }

        DecodedJWT decode = JWT.decode(jwtToken);

        String username = decode.getClaim("username").asString();
        List<GrantedAuthority> authorities = Arrays.stream(decode.getClaim("authorities").asArray(String.class))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, authorities));
        filterChain.doFilter(request, response);
    }
}
