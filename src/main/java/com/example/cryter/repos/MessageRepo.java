package com.example.cryter.repos;

import com.example.cryter.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * "Created by : goodlikemax"
 * "Date: "03.12.2019
 */
public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);

}
