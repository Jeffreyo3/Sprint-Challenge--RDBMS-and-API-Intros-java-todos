package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "todoService")
public class TodoServiceImpl implements TodosService {
    @Autowired
    private TodoRepository todorepo;

    @Override
    public void markComplete(long todoid) {
        Todo todo = todorepo.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo id " + todoid + " Not Found!"));
        todo.setCompleted(true);
    }


}
