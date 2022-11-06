package com.example.projectmysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String abbreviation;
    private int modules;
    private double fee;

    @JsonIgnore
    @ManyToMany(mappedBy = "courseSet", fetch = FetchType.LAZY)
    private Set<Student>  studentSet;

    public Course(Integer id) {
        this.id = id;
    }
}
