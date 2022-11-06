package com.example.projectmysql.service;

import com.example.projectmysql.entity.Course;
import com.example.projectmysql.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }
    public Course get(Integer id){
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course Not Found.");
        return optionalCourse.get();
    }

    public Course add(Course course){
        return courseRepository.save(course);
    }

    public Course update(Integer id, Course course){
        if(!courseRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Course Not Found.");
        course.setId(id);
        return courseRepository.save(course);
    }

    public void delete(Integer id){
        if(!courseRepository.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Course Not Found.");
        courseRepository.deleteById(id);
    }
}
