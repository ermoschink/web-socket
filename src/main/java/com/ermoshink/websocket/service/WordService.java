package com.ermoshink.websocket.service;

import com.ermoshink.websocket.model.MessageWord;
import com.ermoshink.websocket.model.MessageWords;
import com.ermoshink.websocket.model.WordDetails;
import com.ermoshink.websocket.repo.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {
    @Autowired
    private WordRepo wordRepo;

    private String reverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public void addWord(MessageWord messageWord) {
        if (messageWord == null)
            return;
        this.createWordDetail(this.reverseWord((messageWord.getMessage())));
    }

    private void createWordDetail(String data){
        WordDetails wordDetails = new WordDetails();
        wordDetails.setWord( data);
        this.wordRepo.save(wordDetails);
    }

    public MessageWords getWordList() {
        MessageWords messageWords = new MessageWords();
        List<WordDetails> wordDetailsList = this.wordRepo.findAll();
        wordDetailsList.forEach(item -> {
            messageWords.getWords().add(item.getWord());
        });
        return messageWords;
    }
}
