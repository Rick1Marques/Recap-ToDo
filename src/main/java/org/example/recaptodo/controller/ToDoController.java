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

    @DeleteMapping("/{id}")
    public String deleteToDo(@PathVariable String id){
        return toDoService.deleteToDo(id);
    }

    @PutMapping("/{id}")
    public ToDo putToDo(@PathVariable String id, @RequestBody ToDo modToDo){
        return toDoService.updateToDo(id, modToDo);
    }

    @PostMapping("/generator")
    public String getToDoList(@RequestBody String theme) {
        return toDoService.getToDoList(theme);
    }
}
