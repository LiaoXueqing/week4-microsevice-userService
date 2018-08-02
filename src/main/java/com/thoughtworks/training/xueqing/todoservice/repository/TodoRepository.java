package com.thoughtworks.training.xueqing.todoservice.repository;
import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem,Integer>{
    List<TodoItem> findAllByUserIdEquals(Integer id);
    TodoItem findByIdEqualsAndUserIdEquals(Integer id, Integer userId);
}
