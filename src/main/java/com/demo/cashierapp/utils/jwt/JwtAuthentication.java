//package com.demo.cashierapp.utils.jwt;
//
//import com.demo.cashierapp.entity.Employee;
//import com.demo.cashierapp.model.apiService.authentication.EmployeeAuthenticationRequestModel;
//import com.demo.cashierapp.service.role.EmployeeRoleService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.security.Key;
//
//public class JwtAuthentication extends UsernamePasswordAuthenticationFilter {
//    private final AuthenticationManager authenticationManager;
//    private final EmployeeRoleService employeeRoleService;
//
//    public JwtAuthentication(AuthenticationManager authenticationManager, EmployeeRoleService employeeRoleService) {
//        this.authenticationManager = authenticationManager;
//        this.employeeRoleService = employeeRoleService;
//        setFilterProcessesUrl("/login");
//    }
//
//    @Override
//
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            EmployeeAuthenticationRequestModel credentials = new ObjectMapper().readValue(request.getInputStream(), EmployeeAuthenticationRequestModel.class);
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
//        } catch (IOException e) {
//            throw new RuntimeException("Could not read request" + e);
//        }
//    }
//
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) {
//        Key key = Keys.hmacShaKeyFor("-Z6-BFxF3LHYb6NZ5jn4zJGHZ0T-EMnC5-hz-4gknvs".getBytes());
//        String token = Jwts.builder()
//                .claim("roles", employeeRoleService.getAllRolesByUsername(((Employee) authentication.getPrincipal()).getUsername()))
//                .claim("username", ((Employee) authentication.getPrincipal()).getUsername())
//                .claim("firstName", ((Employee) authentication.getPrincipal()).getFirstName())
//                .claim("lastName", ((Employee) authentication.getPrincipal()).getLastName())
//                .signWith(key).compact();
//        response.addHeader("Authorization", token);
//    }
//
//
//}
