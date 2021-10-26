package com.demo.cashierapp.utils.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JwtAuthorization extends BasicAuthenticationFilter {
    public JwtAuthorization(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String jwtToken = request.getHeader("Authorization");

        if (jwtToken == null) {
            chain.doFilter(request, response);
            return;
        }

//        String employee =
//        DecodeJwt decode = JWT.decode(jwtToken);
//
//        String username = decode.getClaim("sub").asString();
//        List<GrantedAuthority> authorities = Arrays.stream(decode.getClaim("authorities").asArray(String.class))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//
//        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, authorities));
//        chain.doFilter(request, response);
    }


}
