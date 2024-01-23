package com.fetchData.consumingData.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestTemplateUser {


    private  int userId;
    private  int id;
    private  String title;

    private  Boolean completed;

}
