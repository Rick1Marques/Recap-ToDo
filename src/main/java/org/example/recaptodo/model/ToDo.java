package org.example.recaptodo.model;

import lombok.With;

@With
public record ToDo(String id, String description, ToDoStatus toDoStatus) {
}
