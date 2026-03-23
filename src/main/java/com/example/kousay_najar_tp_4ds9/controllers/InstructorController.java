package com.example.kousay_najar_tp_4ds9.controllers;

import com.example.kousay_najar_tp_4ds9.Entity.Instructor;
import com.example.kousay_najar_tp_4ds9.Entity.Support;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.IInstructorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
@AllArgsConstructor
public class InstructorController {
    private final IInstructorService instructorService;

    @PostMapping("/addInstructor")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @PostMapping("/updateInstructor")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.updateInstructor(instructor);
    }

    @DeleteMapping("/deleteInstructor/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
    }

    @GetMapping("/getInstructor/{id}")
    public Instructor getInstructor(@PathVariable Long id) {
        return instructorService.getInstructor(id);
    }

    @GetMapping("/getInstructors")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @PostMapping("/addInstructorAndAssignToCourse/{numCourse}")
    public Instructor addInstructorAndAssignToCourse(
            @RequestBody Instructor instructor,
            @PathVariable Long numCourse) {

        return instructorService.addInstructorAndAssignToCourse(instructor, numCourse);
    }

    @GetMapping("/weeks/{numInstructor}/{support}")
    public List<Integer> getWeeks(@PathVariable Long numInstructor,
                                  @PathVariable Support support) {

        return instructorService.numWeeksCourseOfInstructorBySupport(numInstructor, support);
    }

}

