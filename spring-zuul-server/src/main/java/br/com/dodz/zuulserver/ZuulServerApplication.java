package br.com.dodz.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulServerApplication {

	@Bean
	public RequestFilter addRequestFilter() {
		return new RequestFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}
}
