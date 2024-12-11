package com.dhruvdugar.eventservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class EventserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventserviceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

//
//	@Autowired
//	private ClientRegistrationRepository clientRegistrationRepository;
//	@Autowired
//	private OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;
//
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setInterceptors(
//				List.of(
//						new OAuth2RestInterceptor(
//								clientManager(clientRegistrationRepository, oAuth2AuthorizedClientRepository)
//						)
//				)
//		);
//		return restTemplate;
//	}
//
//	@Bean
//	public OAuth2AuthorizedClientManager clientManager(
//			ClientRegistrationRepository clientRegistrationRepository,
//			OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository
//	){
//		OAuth2AuthorizedClientProvider oAuth2AuthorizedClientProvider
//				= OAuth2AuthorizedClientProviderBuilder
//				.builder()
//				.clientCredentials()
//				.build();
//
//		DefaultOAuth2AuthorizedClientManager oAuth2AuthorizedClientManager
//				= new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, oAuth2AuthorizedClientRepository);
//
//		oAuth2AuthorizedClientManager.setAuthorizedClientProvider(oAuth2AuthorizedClientProvider);
//
//		return oAuth2AuthorizedClientManager;
//	}
}
