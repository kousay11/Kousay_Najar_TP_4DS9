package com.example.kousay_najar_tp_4ds9.Services.Interfaces;

import com.example.kousay_najar_tp_4ds9.Entity.Instructor;
import com.example.kousay_najar_tp_4ds9.Entity.Support;

import java.util.List;

public interface IInstructorService {
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    void deleteInstructor(Long id);
    Instructor getInstructor(Long id);
    List<Instructor> getAllInstructors();
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse);
    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
