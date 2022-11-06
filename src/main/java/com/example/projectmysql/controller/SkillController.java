package com.example.projectmysql.controller;

import com.example.projectmysql.entity.Skill;
import com.example.projectmysql.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skills")
@CrossOrigin
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<Skill> get(){
        return skillService.getAll();
    }

    @GetMapping("/{id}")
    public Skill get(@PathVariable Integer id){
        return skillService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Skill add(@RequestBody Skill skill){
        return skillService.add(skill);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Integer id, @RequestBody Skill skill){
        return skillService.update(id, skill);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        skillService.delete(id);
    }
}
