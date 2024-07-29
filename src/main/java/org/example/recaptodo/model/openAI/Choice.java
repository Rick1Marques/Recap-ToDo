package org.example.recaptodo.model.openAI;

//"choices": [
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


public record Choice(ResMessage resMessage) {
}

