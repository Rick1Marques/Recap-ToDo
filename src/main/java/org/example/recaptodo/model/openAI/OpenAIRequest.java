package org.example.recaptodo.model.openAI;

import java.util.List;


//'{
//        "model": "gpt-4o-mini",
//        "messages": [{"role": "user", "content": "Say this is a test!"}],
//        "temperature": 0.7
//        }'

public record OpenAIRequest(String model, List<Message> messages, double temperature) {
}
