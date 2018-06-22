package com.ermoshink.websocket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
public class WordDetails {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column
    @Getter
    @Setter
    private String word;


}
