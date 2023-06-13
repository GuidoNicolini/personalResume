package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.CourseDto;
import com.cvpersonal.cvpersonal.models.Course;
import com.cvpersonal.cvpersonal.services.interfaces.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private final CourseService courseService;
    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody CourseDto courseDto) {

        try {
            Course response = courseService.createCourse(courseDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") String id){
        try {
            Course response = courseService.getCourseById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses(){
        try {
            List<Course> response = courseService.getAllCourse();
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") String id,@Valid @RequestBody CourseDto courseDto){
        try {
            Course response = courseService.updateCourse(courseDto,id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourseById(@PathVariable("id") String id){
        try {
            Course response = courseService.deleteCourse(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
