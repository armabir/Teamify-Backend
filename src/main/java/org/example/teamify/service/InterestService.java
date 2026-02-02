package org.example.teamify.service;

import org.example.teamify.model.Interest;
import org.example.teamify.model.Skill;
import org.example.teamify.repository.InterestRepository;
import org.example.teamify.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestService {

    private final InterestRepository interestRepository;

    public InterestService(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    public Interest getByName(String name){
        return interestRepository.findByName(name).orElse(null);
    }

    public List<Interest> getAll(){
        return interestRepository.findAll();
    }
}
