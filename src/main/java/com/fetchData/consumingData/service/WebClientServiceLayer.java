package com.fetchData.consumingData.service;

import com.fetchData.consumingData.entities.WebClientUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebClientServiceLayer {

    private  final WebClient webClient;
    private  String apiUrl = "https://jsonplaceholder.typicode.com/todos/";

    public Flux<WebClientUser> consumeApi() {
        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToFlux(WebClientUser.class);
//                .collectList()
//                .block();
    }


    public List<WebClientUser> getAllDataByUserId(int userId) {
        String Url = apiUrl + "?userId=" +userId;
        return webClient.get()
                .uri(Url)
                .retrieve()
                .bodyToFlux(WebClientUser.class)
                .collectList()
                .block();
    }


    public List<WebClientUser> getDataById(int id){
        String Url = apiUrl + "?id=" +id;
        return webClient.get()
                .uri(Url)
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }


    public List<WebClientUser> getUserByComplete(Boolean completed) {
        String  Url= apiUrl+"?completed="+completed;
        return webClient.get()
                .uri(Url)
                .retrieve()
                .bodyToFlux(WebClientUser.class)
                 .collectList()
                .block();
    }


//    public Flux<RestTemplateUser> getDataByUserIdAndId(int userId, int id) {
//        return webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/{userId}")
//                        .queryParam("id", id)
//                        .build(userId))
//                .retrieve()
//                .bodyToFlux(RestTemplateUser.class);
//    }


}
