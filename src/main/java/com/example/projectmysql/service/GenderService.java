package com.example.projectmysql.service;

import com.example.projectmysql.entity.Gender;
import com.example.projectmysql.repo.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {
    @Autowired
    private GenderRepository genderRepository;

    public List<Gender> get(){
        return genderRepository.findAll();
    }
    public Gender get(Integer id){
        Optional<Gender> optionalGender = genderRepository.findById(id);
        if(optionalGender.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gender Not Found.");
        return optionalGender.get();
    }

    public Gender add(Gender gender){
        return genderRepository.save(gender);
    }

    public Gender update(Integer id, Gender gender){
        if(!genderRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Gender Not Found.");
        gender.setId(id);
        return genderRepository.save(gender);
    }

    public void delete(Integer id){
        if(!genderRepository.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Gender Not Found.");
        genderRepository.deleteById(id);
    }
}
