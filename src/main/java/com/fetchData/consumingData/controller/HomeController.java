package com.fetchData.consumingData.controller;

import com.fetchData.consumingData.entities.User;
import com.fetchData.consumingData.service.ServiceLayer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {
    @Autowired
     private  final ServiceLayer serviceLayer;

    @GetMapping("/posts")
    public ResponseEntity<List<User>> findAllData(){
        return new ResponseEntity<>( serviceLayer.consumeApi(), HttpStatus.OK);
    }

    @GetMapping("posts/{userId}")
    public ResponseEntity<List<User>> findAllDataByUserId(@PathVariable  int userId){

                List<User> userData = serviceLayer.getAllDataByUserId(userId);
                return new ResponseEntity<>(userData, HttpStatus.OK);

    }

    @GetMapping("post/{id}")
    public  ResponseEntity<User> findUserDataById (@PathVariable int id){
        return  new ResponseEntity<>(serviceLayer.getDataById(id),HttpStatus.OK);
    }

    @GetMapping("/{userId}/{Id}")
    public ResponseEntity<User> findDataByUserIdAndId(@PathVariable int userId, @PathVariable int Id){
        return new ResponseEntity<>(serviceLayer.getDataByUserIdAndId(userId,Id),HttpStatus.OK);
    }


}
