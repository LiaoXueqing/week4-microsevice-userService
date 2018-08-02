package com.thoughtworks.training.xueqing.todoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private String content;
//    @ManyToOne()
//    @JoinColumn(name="todo_id")
//    @JsonIgnore
//    private TodoItem todo;
    private int todo_id;
}
