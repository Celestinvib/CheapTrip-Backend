package com.cheaptrip.demo.security;

import static com.cheaptrip.demo.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.cheaptrip.demo.security.Constants.ISSUER_INFO;
import static com.cheaptrip.demo.security.Constants.SUPER_SECRET_KEY;
import static com.cheaptrip.demo.security.Constants.TOKEN_BEARER_PREFIX;
import static com.cheaptrip.demo.security.Constants.TOKEN_EXPIRATION_TIME;


import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cheaptrip.demo.dto.Account;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private Gson gson = new Gson();

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Account credentials = new ObjectMapper().readValue(request.getInputStream(), Account.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credentials.getEmail(), credentials.getPassword(), credentials.getAuthorities()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String generateAccessToken(Account user) {
		final String authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
		
		return Jwts.builder()
			.setIssuedAt(new Date()) // token Issuing Date
			.setIssuer(ISSUER_INFO) 
			.claim("roles", authorities) 
			.setSubject(user.getEmail()) // Subject for the token 
			.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME)) // Expiration date for the token
			.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)  // What to sign the token with
			.compact();	// Build and sign the token
	
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		//Generate JWT using UserDetails thanks to the parse of Account for getting the principal of auth
		String JWTToken = generateAccessToken((Account) auth.getPrincipal());
			
		//Creates a new json object and adds the jwt to it
        JsonObject json = new JsonObject();
        json.addProperty("token", JWTToken);
        
        //Send the response using the json just created and sets its type
        String userJsonString = this.gson.toJson(json);
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " - " + JWTToken); // Adds the jwt to the response header  
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(userJsonString);
		
	}
	
	
	
}