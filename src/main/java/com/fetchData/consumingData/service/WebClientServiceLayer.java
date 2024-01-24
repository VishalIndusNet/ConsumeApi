package com.fetchData.consumingData.service;

import com.fetchData.consumingData.entities.WebClientUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebClientServiceLayer {

    private  final WebClient webClient;
    private  String apiUrl = "https://jsonplaceholder.typicode.com/todos/";

    public List<WebClientUser> consumeApi() {
        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToFlux(WebClientUser.class)
                .collectList()
                .block();
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


    public WebClientUser getDataById(int id){
        String Url = apiUrl + "/" +id;
        return webClient.get()
                .uri(Url)
                .retrieve()
                .bodyToMono(WebClientUser.class)
                .block();
    }

    public List<WebClientUser> getDataByUserIdAndId(int userId, int id) {
        String  Url= apiUrl+"?userId=" +userId + "&id=" +id;
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





}
