package org.example.recaptodo.service;

import lombok.RequiredArgsConstructor;
import org.example.recaptodo.DB.ToDoRepo;
import org.example.recaptodo.exception.ToDoNotFoundException;
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

    public String deleteToDo(String id) {
        toDoRepo.findById(id).orElseThrow(() -> new ToDoNotFoundException("ToDo with Id " + id + " not found!"));
        toDoRepo.deleteById(id);
        return id;
    }

    public ToDo updateToDo(String id, ToDo modToDo) {
            ToDo oldToDo = toDoRepo.findById(id).orElseThrow(() -> new ToDoNotFoundException("ToDo with Id " + id + " not found!"));
            ToDo updatedToDo = oldToDo.withDescription(modToDo.description()).withToDoStatus(modToDo.toDoStatus());
            return toDoRepo.save(updatedToDo);
    }
}
