package org.example.teamify.repository;

import org.example.teamify.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    Optional<Event> findByTitle(String title);
    boolean existsByTitle(String title);

    // useful filters
    List<Event> findByEventType(String eventType);
}