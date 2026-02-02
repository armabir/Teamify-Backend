package org.example.teamify.repository;

import org.example.teamify.model.Organizer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepository extends MongoRepository<Organizer, String> {
    Optional<Organizer> findByEmail(String email);
    Optional<Organizer> findByName(String name);

    // Boolean checks for validation
    boolean existsByEmail(String email);
    boolean existsByName(String name);
}