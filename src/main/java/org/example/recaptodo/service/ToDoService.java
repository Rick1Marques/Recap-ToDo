package org.example.recaptodo.service;

import lombok.RequiredArgsConstructor;
import org.example.recaptodo.DB.ToDoRepo;
import org.example.recaptodo.exception.ToDoNotFoundException;
import org.example.recaptodo.model.ToDo;
import org.example.recaptodo.model.ToDoDto;
import org.example.recaptodo.model.ToDoStatus;
import org.example.recaptodo.model.openAI.Message;
import org.example.recaptodo.model.openAI.OpenAIRequest;
import org.example.recaptodo.model.openAI.OpenAIResponse;
import org.example.recaptodo.utils.IdService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepo toDoRepo;

    @Value("${app.openai-api-key}")
    private String openAIApiKey;

    private final RestClient restClient = RestClient.builder()
            .baseUrl("https://api.openai.com/v1/chat/completions")
            .defaultHeader("Authorization", "Bearer "+ openAIApiKey)
            .build();

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

    public String getToDoList(String theme) {

        String textReq = "Give me a to do list for the theme: " + theme;
        OpenAIRequest request = new OpenAIRequest("gpt-4o-mini",
                List.of(new Message("user", textReq)),
                0.7);

        OpenAIResponse response = restClient.put()
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(OpenAIResponse.class);

        return response.getAnswer();
    }
}
