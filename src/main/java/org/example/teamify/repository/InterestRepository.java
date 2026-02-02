package org.example.teamify.repository;

import org.example.teamify.model.Interest;
import org.example.teamify.model.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterestRepository extends MongoRepository<Interest, String> {
    Optional<Interest> findByName(String name);
}
