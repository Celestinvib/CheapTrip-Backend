package com.cheaptrip.demo.security;

import static com.cheaptrip.demo.security.Constants.LOGIN_URL;
import static com.cheaptrip.demo.security.Constants.REGISTER_URL;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public WebSecurity(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Disable the use of cookies
		 * 2. CORS configuration is activated with default values
		 * 3. CSRF filter is disabled
		 * 4. It is indicated that the login does not require authentication
		 * 5. It is indicated that the rest of the URLs are secured
		 */
		httpSecurity
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL,REGISTER_URL).permitAll()
			.antMatchers(HttpMethod.GET,
					"/chollos",
					"/chollos/maxprecio/{precio}",
					"/chollos/alojamiento/{id-alojamiento}",
					"/chollos/expiran-pronto",
					"/chollos/{id}",
					"/chollos/ciudad/{id-ciudad}",
					"/chollos/alojamientos/categoria/{categoria}",
					"/alojamientos",
					"/alojamientos/categorias/{categoria}",
					"/alojamientos/valoracion-minima/{valoracion}",
					"/alojamientos/ciudades/{ciudad}",
					"/alojamientos/{id}",
					"/ciudades",
					"/ciudades/{id}",
					"/rasgos",
					"/rasgos/{id}",
					"/vuelos",
					"/vuelos/{id}",
					"/rasgos-alojamientos/{id}",
					"/rasgo-alojamientos/{id-rasgo}",
					"/rasgos-alojamiento/{id-alojamiento}"
					).permitAll()
			.anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager(),userDetailsService));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// The class that retrieves the users and the algorithm to process the passwords is defined
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        //Set the allowed Origins,Methods and Header of the new cors configuration
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        
        //Register and adds the cors configuration
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}