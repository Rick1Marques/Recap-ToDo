package org.example.recaptodo.service;

import lombok.RequiredArgsConstructor;
import org.example.recaptodo.DB.ToDoRepo;
import org.example.recaptodo.model.ToDo;
import org.example.recaptodo.model.ToDoDto;
import org.example.recaptodo.model.ToDoStatus;
import org.example.recaptodo.utils.IdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepo toDoRepo;

    public ToDo addToDo(ToDoDto toDoDto) {
        ToDo newToDo = new ToDo(IdService.randomId(),toDoDto.description(), ToDoStatus.OPEN);
        return toDoRepo.save(newToDo);
    }

    public List<ToDo> findAllTodos() {
        return toDoRepo.findAll();
    }
}
