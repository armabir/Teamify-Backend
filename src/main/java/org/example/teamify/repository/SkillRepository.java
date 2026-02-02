package org.example.teamify.repository;

import org.example.teamify.model.Skill;
import org.example.teamify.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends MongoRepository<Skill, String> {
    Optional<Skill> findByName(String name);
}
