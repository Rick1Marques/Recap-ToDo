package org.example.recaptodo.controller;

import lombok.RequiredArgsConstructor;
import org.example.recaptodo.model.ToDo;
import org.example.recaptodo.model.ToDoDto;
import org.example.recaptodo.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAllToDos(){
        return toDoService.findAllTodos();
    }

    @PostMapping
    public ToDo postToDo(@RequestBody ToDoDto toDoDto){
        return toDoService.addToDo(toDoDto);
    }

}
