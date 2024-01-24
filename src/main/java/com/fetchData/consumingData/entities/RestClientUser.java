package com.fetchData.consumingData.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RestClientUser {

    private  int userId;
    private  int id;
    private  String title;
    private  Boolean completed;
}

