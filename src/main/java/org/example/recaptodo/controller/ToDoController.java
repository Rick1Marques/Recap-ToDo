package org.example.recaptodo.controller;

import lombok.RequiredArgsConstructor;
import org.example.recaptodo.model.ToDo;
import org.example.recaptodo.model.ToDoDto;
import org.example.recaptodo.service.ToDoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping
    public ToDo postToDo(ToDoDto toDoDto){
        return toDoService.addToDo(toDoDto);
    }

}
