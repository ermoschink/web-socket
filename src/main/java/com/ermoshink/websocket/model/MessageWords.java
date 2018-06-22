package com.ermoshink.websocket.model;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Data
public class MessageWords {
    @Getter
    private List<String> words = new ArrayList<>();
}