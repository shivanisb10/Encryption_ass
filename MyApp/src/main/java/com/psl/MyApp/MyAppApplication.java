package com.psl.MyApp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

	// @Bean
	 // CorsConfigurationSource corsConfigurationSource() {
	  //  CorsConfiguration configuration = new CorsConfiguration();
	  //  configuration.addAllowedOrigin("*");
	   // configuration.addAllowedHeader("*");
	   // configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	  //  configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
	  //  UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	  //  source.registerCorsConfiguration("/**", configuration);
	  ///  return source;
	  //}
}
