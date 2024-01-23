package com.fetchData.consumingData.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientAppConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
    @Bean
    public WebClient webClient (WebClient.Builder builder){
        return builder.build();
    }

}
