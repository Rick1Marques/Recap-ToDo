package org.example.recaptodo.DB;

import org.example.recaptodo.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepo extends MongoRepository<ToDo, String> {
}
