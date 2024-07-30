package org.example.recaptodo.service;

import org.example.recaptodo.DB.ToDoRepo;
import org.example.recaptodo.model.ToDo;
import org.example.recaptodo.model.ToDoDto;
import org.example.recaptodo.model.ToDoStatus;
import org.example.recaptodo.utils.IdService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ToDoServiceTest {

    private final ToDoRepo mockToDoRepository = mock(ToDoRepo.class);
    private final IdService mockIdService = mock(IdService.class);

    @Test
    void addToDo() {

        ToDo toDo = new ToDo("123", "testing", ToDoStatus.OPEN);
        when(mockToDoRepository.save(toDo)).thenReturn(toDo);

        when(mockIdService.randomId()).thenReturn("123");

        ToDoService toDoService = new ToDoService(mockToDoRepository, mockIdService);

        ToDo result = toDoService.addToDo(new ToDoDto("testing"));

        verify(mockToDoRepository).save(toDo);

        assertEquals(toDo, result);

    }

}