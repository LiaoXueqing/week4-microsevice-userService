package com.thoughtworks.training.xueqing.todoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
//    @JsonIgnore
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String todo;
    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("completed")
    private Boolean completed;
    @JsonProperty("generateTime")
    private String generateTime;
//    @JsonProperty("status")
//    public Boolean status(){
//        return false;
//    }
//
//    @JsonProperty("completed")
//    public Boolean completed(){
//        return false;
//    }
//
//    @JsonProperty("generateTime")
//    public String generateTime(){
//        return "2018-7-26";
//    }

}
