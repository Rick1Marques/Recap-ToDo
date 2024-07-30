package org.example.recaptodo.model.openAI;

//                      "message": {
//                                "role": "assistant",
//                                "content": "\n\nThis is a test!"
//                                 },

public record ResMessage(String role, String content) {
}
