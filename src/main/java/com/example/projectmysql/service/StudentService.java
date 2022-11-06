package com.example.projectmysql.service;

import com.example.projectmysql.entity.Student;
import com.example.projectmysql.repo.CourseRepository;
import com.example.projectmysql.repo.SkillRepository;
import com.example.projectmysql.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SkillRepository skillRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student get(Integer id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found.");
        return optionalStudent.get();
    }

    public Student add(Student student){
        return studentRepository.save(student);
    }

    public Student update(Integer id, Student student){
        if(!studentRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found.");
        student.setId(id);
        return studentRepository.save(student);
    }

    public void delete(Integer id){
        if(!studentRepository.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found.");
        studentRepository.deleteById(id);
    }
}
