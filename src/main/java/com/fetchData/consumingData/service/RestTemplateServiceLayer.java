package com.fetchData.consumingData.service;

import com.fetchData.consumingData.entities.RestTemplateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestTemplateServiceLayer {

    @Autowired
    private  final RestTemplate restTemplate;
    private  String url = "https://jsonplaceholder.typicode.com/todos/";

    public List<RestTemplateUser> consumeApi(){
        return restTemplate.getForObject(url, List.class);
    }

    public List<RestTemplateUser> getAllDataByUserId(int userId) {
        String userApiUrl = url + "?userId=" + userId;
        return restTemplate.getForObject(userApiUrl, List.class);
    }
    public RestTemplateUser getDataById(int id){
        String userApi= url+ "/{id}";
        return restTemplate.getForObject(userApi, RestTemplateUser.class,id);
    }

   public List<RestTemplateUser> getUserByComplete(Boolean completed){
        String  userApi= url+"?completed="+completed;
        return restTemplate.getForObject(userApi,List.class);
    }


    //    public User getDataByUserIdAndId(int userId, int id) {
//        String apiUrl = url + "?userId=" + userId + "&id=" + id;
//        return restTemplate.getForObject(apiUrl, User.class);
//    }
    public List<RestTemplateUser> getDataByUserIdAndId(int userId, int id) {
        String apiUrl = url + "?userId=" + userId + "&id=" + id;
        return restTemplate.getForObject(apiUrl, List.class);
    }
//    public List<RestTemplateUser> getDataByUserIdAndId(int userId, int id) {
//        String apiUrl = UriComponentsBuilder.fromUriString(url + "/{userId}")
//                .queryParam("id", id)
//                .buildAndExpand(userId)
//                .toUriString();
//        return restTemplate.getForObject(apiUrl, List.class);
    }

