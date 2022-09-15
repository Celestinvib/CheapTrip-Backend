package com.cheaptrip.demo.security;

import static com.cheaptrip.demo.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.cheaptrip.demo.security.Constants.SUPER_SECRET_KEY;
import static com.cheaptrip.demo.security.Constants.TOKEN_BEARER_PREFIX;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * 	Class constructor
	 * 	@param authManager
	 */
	public JWTAuthorizationFilter(AuthenticationManager authManager, UserDetailsService userDetailsService) {
		super(authManager);
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Get the HTTP Request's Header
		String HTTPReqtHdr = request.getHeader(HEADER_AUTHORIZACION_KEY);
		
		// Check if we have headers in the request or a token
		if (HTTPReqtHdr == null || !HTTPReqtHdr.startsWith(TOKEN_BEARER_PREFIX)) {
			// If we don't, filter out the request
			chain.doFilter(request, response);
			return;
		}
		
		String username = Jwts.parser() // Parse the Bearer Token
				.setSigningKey(SUPER_SECRET_KEY) //Sets the signature key with the constant secret key
				.parseClaimsJws(HTTPReqtHdr.replace(TOKEN_BEARER_PREFIX, ""))
				.getBody() // Get the body of the token
				.getSubject(); //Get the subject, which (If all's correct) should be the username


		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(HTTPReqtHdr.replace(TOKEN_BEARER_PREFIX, ""), SecurityContextHolder.getContext().getAuthentication(), userDetails);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        logger.info("authenticated user " + username + ", setting security context");
        SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Filter it based on the type
		chain.doFilter(request, response);
	}

	UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication authentication, final UserDetails userDetails) {
		 final JwtParser jwtParser = Jwts.parser().setSigningKey(SUPER_SECRET_KEY);

	        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

	        final Claims claims = claimsJws.getBody();

	        final Collection<? extends GrantedAuthority> authorities =
	                Arrays.stream(claims.get("roles").toString().split(","))
	                        .map(SimpleGrantedAuthority::new)
	                        .collect(Collectors.toList());

	        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}
}