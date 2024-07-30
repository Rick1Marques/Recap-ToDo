package org.example.recaptodo.model.openAI;

//        "messages": [{"role": "user", "content": "Say this is a test!"}],

public record Message(String role, String content) {
}
