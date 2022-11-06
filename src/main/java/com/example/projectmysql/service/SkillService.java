package com.example.projectmysql.service;

import com.example.projectmysql.entity.Skill;
import com.example.projectmysql.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAll(){
        return skillRepository.findAll();
    }
    public Skill get(Integer id){
        Optional<Skill> optionalSkill = skillRepository.findById(id);
        if(optionalSkill.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill Not Found.");
        return optionalSkill.get();
    }

    public Skill add(Skill skill){
        return skillRepository.save(skill);
    }

    public Skill update(Integer id, Skill skill){
        if(!skillRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Skill Not Found.");
        skill.setId(id);
        return skillRepository.save(skill);
    }

    public void delete(Integer id){
        if(!skillRepository.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Skill Not Found.");
        skillRepository.deleteById(id);
    }
}
