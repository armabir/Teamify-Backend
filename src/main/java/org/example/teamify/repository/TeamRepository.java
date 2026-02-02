package org.example.teamify.repository;

import org.example.teamify.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {

    Optional<Team> findByName(String name);

    boolean existsByName(String name);

    List<Team> findByMemberUsernamesContaining(String username);
}