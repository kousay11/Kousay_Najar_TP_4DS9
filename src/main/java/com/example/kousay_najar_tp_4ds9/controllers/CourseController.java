package com.example.kousay_najar_tp_4ds9.controllers;

import com.example.kousay_najar_tp_4ds9.Entity.Course;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
public class CourseController {
    ICourseService courseService;
    @PostMapping("/addCourse")
    Course ajouterCours(@RequestBody Course course){
        return courseService.addCourse(course);
    }
    @PostMapping("/updateCourse")
    Course updateCours(@RequestBody Course course){
        return courseService.updateCourse(course);
    }
    @DeleteMapping("/deleteCourse/{id}")
    void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
    @GetMapping("/getCourse/{id}")
    Course getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }
    @GetMapping("/getCourses/")
    List<Course> getCourse(){
        return courseService.getALLCourses();
    }
}
