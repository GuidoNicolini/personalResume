package com.cvpersonal.cvpersonal.repositories;


import com.cvpersonal.cvpersonal.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
}
