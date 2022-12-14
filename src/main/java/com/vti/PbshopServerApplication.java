package com.vti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;import vti.KShopApplication;

@SpringBootApplication
public class PbshopServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KShopApplication.PbshopServerApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") //	every /api...
						.allowedOrigins("\"http://127.0.0.1:5500\"")
						.allowedMethods("GET","POST","PUT","DELETE");
			}
		} ;
	}

}
