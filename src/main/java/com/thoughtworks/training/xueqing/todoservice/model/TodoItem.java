package com.thoughtworks.training.xueqing.todoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "todo")
@Where(clause = "deleted = false")
public class TodoItem {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Boolean deleted;
    private Boolean completed;
    private String time;
    @Column(columnDefinition = "user_id")
    private int userId;
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="todo_id")
    private List<Task> tasks;
}
