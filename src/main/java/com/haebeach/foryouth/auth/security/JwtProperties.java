package com.haebeach.foryouth.auth.security;

public interface JwtProperties {
    String SECRET = "djeon";
    int EXPIRATION_TIME = 10000;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
