package com.example.projectmysql.controller;

import com.example.projectmysql.entity.Course;
import com.example.projectmysql.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> get(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable Integer id){
        return courseService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course add(@RequestBody Course course){
        return courseService.add(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Integer id, @RequestBody Course course){
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        courseService.delete(id);
    }
}
