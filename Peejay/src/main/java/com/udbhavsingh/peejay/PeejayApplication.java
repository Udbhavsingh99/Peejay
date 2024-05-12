package com.udbhavsingh.peejay;

import com.udbhavsingh.peejay.client.PeejayClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class PeejayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeejayApplication.class, args);
	}

	@Bean
	PeejayClient dadJokeClient() {
		WebClient webClient = WebClient.builder()
				.baseUrl("https://icanhazdadjoke.com")
				.defaultHeader("Accept", "application/json")
				.build();

		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
		return factory.createClient(PeejayClient.class);
	}

}
