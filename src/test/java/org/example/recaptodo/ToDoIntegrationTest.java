package org.example.recaptodo;

import org.example.recaptodo.DB.ToDoRepo;
import org.example.recaptodo.model.ToDo;
import org.example.recaptodo.model.ToDoStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoIntegrationTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ToDoRepo toDoRepo;

    @Test
    @DirtiesContext
    void getAllTodosTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        []
                  """));
    }

    @Test
    @DirtiesContext
    void postToDo() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                {
                  "description": "testing"
                }
"""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                {
                  "description": "testing"
                }
                """
))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    @DirtiesContext
    void deleteToDo() throws Exception {
        toDoRepo.save(new ToDo("1", "testing", ToDoStatus.OPEN));

        mvc.perform(MockMvcRequestBuilders.delete("/api/todo/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DirtiesContext
    void putToDo()throws Exception {
        toDoRepo.save(new ToDo("1", "testing", ToDoStatus.OPEN));

        mvc.perform(MockMvcRequestBuilders.put("/api/todo/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                {
                "id": "1",
                "description": "testingPut",
                "toDoStatus": "OPEN"
                }
"""
                ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                {
                "id": "1",
                "description": "testingPut",
                "toDoStatus": "OPEN"
                }
"""));
    }
}
