package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.EducationDto;
import com.cvpersonal.cvpersonal.models.Education;
import com.cvpersonal.cvpersonal.services.interfaces.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private final EducationService educationService;
    @PostMapping
    public ResponseEntity<Education> createEducation(@Valid @RequestBody EducationDto educationDto) {

        try {
            Education response = educationService.createEducation(educationDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable("id") String id){
        try {
            Education response = educationService.getEducationById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Education>> getAllEducations(){
        try {
            List<Education> response = educationService.getAllEducation();
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable("id") String id,@Valid @RequestBody EducationDto educationDto){
        try {
            Education response = educationService.updateEducation(educationDto,id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Education> deleteEducationById(@PathVariable("id") String id){
        try {
            Education response = educationService.deleteEducation(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
