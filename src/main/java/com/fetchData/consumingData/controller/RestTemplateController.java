package com.fetchData.consumingData.controller;

import com.fetchData.consumingData.entities.RestTemplateUser;
import com.fetchData.consumingData.service.RestTemplateServiceLayer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class RestTemplateController {
    @Autowired
     private  final RestTemplateServiceLayer serviceLayer;

    @GetMapping("/all")
    public ResponseEntity<List<RestTemplateUser>> findAllData(){
        return new ResponseEntity<>( serviceLayer.consumeApi(), HttpStatus.OK);
    }

    @GetMapping("/posts/{userId}")
    public ResponseEntity<List<RestTemplateUser>> findAllDataByUserId(@PathVariable  int userId){

                List<RestTemplateUser> userData = serviceLayer.getAllDataByUserId(userId);
                return new ResponseEntity<>(userData, HttpStatus.OK);

    }

    @GetMapping("/post/{id}")
    public  ResponseEntity<RestTemplateUser> findUserDataById (@PathVariable int id){
        return  new ResponseEntity<>(serviceLayer.getDataById(id),HttpStatus.OK);
    }

    @GetMapping("/post/complete")
    public  ResponseEntity<List<RestTemplateUser>> findAllUserByComplete(@RequestParam("complete") Boolean completed){
        return new ResponseEntity<>(serviceLayer.getUserByComplete(completed),HttpStatus.OK);
    }

    @GetMapping("/{userId}/{Id}")
    public ResponseEntity<List<RestTemplateUser>> findDataByUserIdAndId(@PathVariable int userId, @PathVariable int Id){
        return new ResponseEntity<>(serviceLayer.getDataByUserIdAndId(userId,Id),HttpStatus.OK);
    }
}
