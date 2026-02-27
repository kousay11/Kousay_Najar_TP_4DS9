package com.example.kousay_najar_tp_4ds9.Services.Implementations;

import com.example.kousay_najar_tp_4ds9.Entity.Course;
import com.example.kousay_najar_tp_4ds9.Repository.CourseRepository;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService {
    private final CourseRepository CourseRepository ;
    //bean repo -> bean service
    @Override
    public Course addCourse(Course course) {
        return CourseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return CourseRepository.save(course);

    }

    @Override
    public void deleteCourse(Long id) {
        CourseRepository.deleteById(id);
    }

    @Override
    public Course getCourse(Long id) {
        //Mth1
        // return CourseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course avec id " + id + " introuvable"));
        //Mth2
        // return CourseRepository.findById(id).get();
        //Mth3
        Optional<Course> optionalCourse = CourseRepository.findById(id);

        if (optionalCourse.isEmpty()) {
            throw new RuntimeException("Course avec l'id " + id + " est introuvable");
        }

        return optionalCourse.get();
    }

    @Override
    public List<Course> getALLCourses() {
        return CourseRepository.findAll();
    }
}
