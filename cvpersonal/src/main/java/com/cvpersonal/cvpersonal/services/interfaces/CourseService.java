package com.cvpersonal.cvpersonal.services.interfaces;

import com.cvpersonal.cvpersonal.dtos.request.CourseDto;
import com.cvpersonal.cvpersonal.models.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(CourseDto courseDto);
    Course getCourseById(String id);
    List<Course> getAllCourse();
    Course updateCourse(CourseDto courseDto, String id);

    Course deleteCourse(String id);
}
