package org.example.recaptodo.service;

import lombok.RequiredArgsConstructor;
import org.example.recaptodo.DB.ToDoRepo;
import org.example.recaptodo.model.ToDo;
import org.example.recaptodo.model.ToDoDto;
import org.example.recaptodo.model.ToDoStatus;
import org.example.recaptodo.utils.IdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        toDoRepo.deleteById(id);
        return id;
    }

    public ToDo updateToDo(String id, ToDo modToDo) {
            Optional<ToDo> oldToDo = toDoRepo.findById(id);
            if(oldToDo.isPresent()){
                ToDo updatedToDo = oldToDo.get().withDescription(modToDo.description()).withToDoStatus(modToDo.toDoStatus());
                return toDoRepo.save(updatedToDo);
            }
        return null;
    }
}
