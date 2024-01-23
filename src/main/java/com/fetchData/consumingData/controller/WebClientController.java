package com.fetchData.consumingData.controller;

import com.fetchData.consumingData.entities.WebClientUser;
import com.fetchData.consumingData.service.WebClientServiceLayer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/web")
public class WebClientController {

        private final WebClientServiceLayer webClientService;

        @GetMapping("/all")
        public ResponseEntity<Flux<WebClientUser>> consumeApi() {
            return ResponseEntity.ok( webClientService.consumeApi());
        }

        @GetMapping("/posts/{userId}")
        public ResponseEntity<List<WebClientUser> > getAllDataByUserId(@PathVariable int userId) {
            return ResponseEntity.ok(webClientService.getAllDataByUserId(userId));
        }

        @GetMapping("/post/{id}")
        public ResponseEntity<List<WebClientUser>> getDataById(@PathVariable int id) {
            return ResponseEntity.ok(webClientService.getDataById(id));
        }

        @GetMapping("/users/complete")
        public ResponseEntity<List<WebClientUser>> getUserByComplete(@RequestParam Boolean completed) {
            return ResponseEntity.ok(webClientService.getUserByComplete(completed));
        }

//        @GetMapping("/webclient/users/{userId}/{id}")
//        public Flux<WebClientUser> getDataByUserIdAndId(@PathVariable int userId, @PathVariable int id) {
//            return webClientService.getDataByUserIdAndId(userId, id);
//        }

}
