package com.demo.cashierapp.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        String jwtToken = ((HttpServletRequest)servletRequest).getHeader("Authorization");

//        final DecodedJWT decode = JWT.decode("eyJklGciOiJIUzI1NiJ9.eyJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sInVzZXJuYW1lIjoicnV6YW5uYSIsImZpcnN0TmFtZSI6IlJ1emFubmEiLCJsYXN0TmFtZSI6IlpvaHJhYnlhbiJ9.d8JGfwY-w3rsPEFmi-UT--kgC_7u9K6ZAHCMjv3LvdI");
//        decode1.getHeader().
//        System.out.println(decode1);

        if (jwtToken == null || jwtToken.equals("undefined")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        DecodedJWT decode = JWT.decode(jwtToken);
        final Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SecurityConst.KEY).parseClaimsJws(jwtToken);
//        final String algorithm = decode.getAlgorithm();
//        System.out.println(decode);
//        decode.
//
//        JWT.require(null).build().verify(jwtToken);
        String username = claimsJws.getBody().get("username").toString();
//        String username = decode.getClaim("username").asString();
        List<GrantedAuthority> authorities = Arrays.stream(decode.getClaim("authorities").asArray(String.class))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, authorities));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
