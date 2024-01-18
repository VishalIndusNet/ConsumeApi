package com.fetchData.consumingData.service;

import com.fetchData.consumingData.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceLayer {

    @Autowired
    private  final RestTemplate restTemplate;
    private  String url = "https://jsonplaceholder.typicode.com/todos/";

    public List<User> consumeApi(){
        return restTemplate.getForObject(url, List.class);
    }

    public List<User> getAllDataByUserId(int userId) {
        String userApiUrl = url + "?userId=" + userId;
        return restTemplate.getForObject(userApiUrl, List.class);
    }
    public User getDataById(int id){
        String userApi= url+ "/{id}";
        return restTemplate.getForObject(userApi, User.class,id);
    }

//    public User getDataByUserIdAndId(int userId, int id) {
//        String apiUrl = url + "?userId=" + userId + "&id=" + id;
//        return restTemplate.getForObject(apiUrl, User.class);
//    }
    public User getDataByUserIdAndId(int userId, int id) {
        String apiUrl = url + userId + "?id=" + id;
        return restTemplate.getForObject(apiUrl, User.class);
    }
}
