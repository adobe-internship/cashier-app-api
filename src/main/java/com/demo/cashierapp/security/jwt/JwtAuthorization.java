package com.demo.cashierapp.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthorization implements Filter {


//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String jwtToken = ((HttpServletRequest)servletRequest).getHeader("authorization");

        if (jwtToken == null || jwtToken.equals("undefined")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        DecodedJWT decode = JWT.decode(jwtToken);

        String username = decode.getClaim("username").asString();
        List<GrantedAuthority> authorities = Arrays.stream(decode.getClaim("authorities").asArray(String.class))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, authorities));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
