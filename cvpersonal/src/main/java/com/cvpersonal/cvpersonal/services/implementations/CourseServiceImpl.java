package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.CourseDto;
import com.cvpersonal.cvpersonal.models.Course;
import com.cvpersonal.cvpersonal.repositories.CourseRepository;
import com.cvpersonal.cvpersonal.services.interfaces.CourseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final ModelMapper modelMapper;
    @Autowired
    private CourseRepository repository;
    @Override
    public Course createCourse(CourseDto courseDto) {
        return null;
    }

    @Override
    public Course getCourseById(String id) {
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return null;
    }

    @Override
    public Course updateCourse(CourseDto courseDto, String id) {
        return null;
    }

    @Override
    public Course deleteCourse(String id) {
        return null;
    }
}
