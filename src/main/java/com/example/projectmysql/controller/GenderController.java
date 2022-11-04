package com.example.projectmysql.controller;

import com.example.projectmysql.entity.Gender;
import com.example.projectmysql.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genders")
@CrossOrigin
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping
    public List<Gender> get(){
        return genderService.get();
    }

    @GetMapping("/{id}")
    public Gender get(@PathVariable Integer id){
        return genderService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gender add(@RequestBody Gender gender){
        return genderService.add(gender);
    }

    @PutMapping("/{id}")
    public Gender update(@PathVariable Integer id, @RequestBody Gender gender){
        return genderService.update(id, gender);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        genderService.delete(id);
    }
}
