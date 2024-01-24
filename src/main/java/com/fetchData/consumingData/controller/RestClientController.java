package com.fetchData.consumingData.controller;

import com.fetchData.consumingData.entities.RestClientUser;
import com.fetchData.consumingData.service.RestClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Rest-Client")
public class RestClientController {

    @Autowired
    private  final RestClientService restClientService;

    @GetMapping("/all")
    public ResponseEntity<List<RestClientUser>> findAllData(){
        return ResponseEntity.ok(restClientService.consumeApi());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RestClientUser> findDataById(@PathVariable int id){
        return ResponseEntity.ok(restClientService.getDataById(id));
    }

    @GetMapping("/userId/{userid}")
    public ResponseEntity<List<RestClientUser>> findDataByUserId(@PathVariable int userid) {

        return ResponseEntity.ok(restClientService.getDataByUserId(userid));
    }

    @GetMapping("/{userId}/{Id}")
    public ResponseEntity<List<RestClientUser>> findDataByUserId_Id(@PathVariable int userId, @PathVariable int Id){
        return ResponseEntity.ok(restClientService.getDataByUserId_Id(userId,Id));
    }

    @GetMapping("/completed")
    private ResponseEntity<List<RestClientUser>> findByComplete(@RequestParam Boolean completed){
        return ResponseEntity.ok(restClientService.getDataByComplete(completed));
    }

}
