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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Account credenciales = new ObjectMapper().readValue(request.getInputStream(), Account.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credenciales.getEmail(), credenciales.getPassword(), credenciales.getAuthorities()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String generateAccessToken(Account user) {
		final String authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
		
		return Jwts.builder()
			// Token Issuing Date
			.setIssuedAt(new Date())
			// Token Issuer (Us)
			.setIssuer(ISSUER_INFO)
			.claim("roles", authorities)
			// Subject for the Token (User who requested it)
			.setSubject(user.getEmail())
			// Expiration date for the token
			.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
			// What to sign the token with
			.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
			// Build and sign the token
			.compact();		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String JWTToken = generateAccessToken((Account) auth.getPrincipal());
		
		// Add the token to the header...
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + JWTToken);

		// ...and response
		response.getWriter().write("Logged in succesfully!\nWelcome " + ((Account) auth.getPrincipal()).getName() + ", your token is: " + JWTToken + "\nCurrent roles: " + ((Account) auth.getPrincipal()).getRoles().toString());
		
		// Print it on Spring
		System.out.println(response.getHeader(HEADER_AUTHORIZACION_KEY));
	
	}
	
	
	
}