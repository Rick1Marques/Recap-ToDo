package org.example.recaptodo.model.openAI;

//{
//        "id": "chatcmpl-abc123",
//        "object": "chat.completion",
//        "created": 1677858242,
//        "model": "gpt-4o-mini",
//        "usage": {
//              "prompt_tokens": 13,
//              "completion_tokens": 7,
//              "total_tokens": 20
//                },
//        "choices": [
//                      {
//                      "message": {
//                                "role": "assistant",
//                                "content": "\n\nThis is a test!"
//                                 },
//                      "logprobs": null,
//                      "finish_reason": "stop",
//                      "index": 0
//                      }
//        ]
//}

import java.util.List;

public record OpenAIResponse(List<Choice> choices) {

    public String getAnswer(){
        return choices().get(0).resMessage().content();
    }
}
