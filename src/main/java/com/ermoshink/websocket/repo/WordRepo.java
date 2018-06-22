package com.ermoshink.websocket.repo;

import com.ermoshink.websocket.model.WordDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WordRepo extends JpaRepository<WordDetails, Long> {
    List<WordDetails> findAll();
}
