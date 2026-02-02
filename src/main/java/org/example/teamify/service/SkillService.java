package org.example.teamify.service;

import org.example.teamify.model.Skill;
import org.example.teamify.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill getByName(String name){
        return skillRepository.findByName(name).orElse(null);
    }

    public List<Skill> getAll(){
        return skillRepository.findAll();
    }
}
