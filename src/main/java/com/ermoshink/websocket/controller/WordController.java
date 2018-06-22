package com.ermoshink.websocket.controller;

import com.ermoshink.websocket.model.MessageWords;
import com.ermoshink.websocket.model.MessageWord;
import com.ermoshink.websocket.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WordController {

    @Autowired
    private WordService wordService;

    @MessageMapping("/receiving")
    @SendTo("/topic/departure")
    public MessageWords greeting(MessageWord message) throws Exception {
        if(message == null) return null;
        this.wordService.addWord(message);
        return this.wordService.getWordList();
    }
}
