package com.fetchData.consumingData.service;

import com.fetchData.consumingData.entities.RestClientUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


import java.util.List;

@Service
@RequiredArgsConstructor
public class RestClientService {

    @Autowired
    private final RestClient restClient;

    private  String url = "https://jsonplaceholder.typicode.com/todos/";

//    public RestClientService() {
//        restClient = RestClient.builder()
//                .baseUrl(url)
//                .build();
//    }

    public List<RestClientUser> consumeApi(){
        return restClient.get()
                .uri(url)
                .retrieve()

                .body(List.class);
    }


    public RestClientUser getDataById(int id){
        return restClient.get()
                .uri(url+"/"+id)
                .retrieve()
                .body(RestClientUser.class);
    }



    public List<RestClientUser> getDataByUserId(int userId){
        return restClient.get()
                .uri(url+"?userId="+userId)
                .retrieve()
                .body(List.class);
    }

    public List<RestClientUser> getDataByUserId_Id(int userId,int id){
        String  Url= url+"?userId=" +userId + "&id=" +id;
        return restClient.get()
                .uri(Url)
                .retrieve()
                .body(List.class);
    }

    public List<RestClientUser> getDataByComplete(Boolean completed){
        return restClient.get()
                .uri(url+"?completed="+completed)
                .retrieve()
                .body(List.class);
    }

}
