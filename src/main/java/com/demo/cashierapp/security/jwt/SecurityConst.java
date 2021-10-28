package com.demo.cashierapp.security.jwt;

import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class SecurityConst {
    public static final Key KEY = Keys.hmacShaKeyFor("-Z6-BFxF3LHYb6NZ5jn4zJGHZ0T-EMnC5-hz-4gknvs".getBytes());
}
