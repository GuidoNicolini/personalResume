package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.CourseDto;
import com.cvpersonal.cvpersonal.models.Course;
import com.cvpersonal.cvpersonal.models.Course;
import com.cvpersonal.cvpersonal.repositories.CourseRepository;
import com.cvpersonal.cvpersonal.repositories.ProfileRepository;
import com.cvpersonal.cvpersonal.services.interfaces.CourseService;
import com.cvpersonal.cvpersonal.utils.Verifier;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final ModelMapper modelMapper;
    @Autowired
    private CourseRepository repository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private Verifier verifier;
    @Override
    @Transactional
    public Course createCourse(CourseDto courseDto) {
        try {
            if (profileRepository.existsById(courseDto.getIdProfile())) {
                Course course = modelMapper.map(courseDto, Course.class);
                return repository.save(course);
            }else{
                throw new IllegalArgumentException("Profile does not exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Course", e);
        }
    }

    @Override
    @Transactional
    public Course getCourseById(String id) {
        verifier.IdVerification(id);

        Optional<Course> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Course not found for ID: " + id));
    }

    @Override
    @Transactional
    public List<Course> getAllCourse() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Course updateCourse(CourseDto courseDto, String id) {
        verifier.IdVerification(id);

        Course answer = getCourse(id);

       answer.setName(courseDto.getName());
       answer.setDate(courseDto.getDate());
       answer.setDescription(courseDto.getDescription());
       answer.setEstablishment(courseDto.getEstablishment());
       answer.setLogo(courseDto.getLogo());

        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update course", e);
        }
        }

    @Override
    @Transactional
    public Course deleteCourse(String id) {
        verifier.IdVerification(id);

        Course answer = getCourse(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete course", e);
        }
    }

    private Course getCourse(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course not found for ID: " + id));
    }
}
