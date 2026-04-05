package com.example.kousay_najar_tp_4ds9.Services.Implementations;


import com.example.kousay_najar_tp_4ds9.Entity.Course;
import com.example.kousay_najar_tp_4ds9.Entity.Registration;
import com.example.kousay_najar_tp_4ds9.Entity.Instructor;
import com.example.kousay_najar_tp_4ds9.Entity.Support;
import com.example.kousay_najar_tp_4ds9.Repository.CourseRepository;
import com.example.kousay_najar_tp_4ds9.Repository.InstructorRepository;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.IInstructorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class InstructorServiceImpl implements IInstructorService {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public Instructor getInstructor(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor avec id " + id + " introuvable"));
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        //setCourses(Set.of(course)) ecrase les anciens cours
        if (instructor.getCourses() == null) {
            instructor.setCourses(new HashSet<>());
        }
        instructor.getCourses().add(course);
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        Instructor instructor = instructorRepository.findById(numInstructor)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        List<Integer> weeks = new ArrayList<>();

        for (Course c : instructor.getCourses()) {
            if (c.getSupport() == support) {
                for (Registration r : c.getRegistrations()) {
                    weeks.add(r.getNumWeek());
                }
            }
        }

        return weeks;
    }
    
     public Instructor addInstructorAndAssignToCourses(Instructor instructor, List<Long> numCourses) {
        List<Course> courses = courseRepository.findAllById(numCourses);

        if (courses.size() != numCourses.size()) {
            throw new RuntimeException("One or more courses were not found");
        }

        if (instructor.getCourses() == null) {
            instructor.setCourses(new HashSet<>());
        }
        instructor.getCourses().addAll(courses);

        return instructorRepository.save(instructor);
    }

}
