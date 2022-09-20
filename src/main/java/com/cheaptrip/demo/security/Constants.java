package com.cheaptrip.demo.security;

public class Constants {

 // Spring Security
 public static final String REGISTER_URL = System.getenv("SPRING_REGISTER_URL");
 public static final String LOGIN_URL = System.getenv("SPRING_LOGIN_URL");
 public static final String HEADER_AUTHORIZACION_KEY = System.getenv("SPRING_HEADER_AUTHORIZACION_KEY");
 public static final String TOKEN_BEARER_PREFIX = System.getenv("SPRING_TOKEN_BEARER_PREFIX");

 // JWT

 public static final String ISSUER_INFO = System.getenv("JWT_ISSUER_INFO");
 public static final String SUPER_SECRET_KEY = System.getenv("JWT_SUPER_SECRET_KEY");
 public static final long TOKEN_EXPIRATION_TIME = 7_200_000; // 2 hours
}