
package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.WorkExperienceDto;
import com.cvpersonal.cvpersonal.models.WorkExperience;
import com.cvpersonal.cvpersonal.services.interfaces.WorkExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/workexperience")
public class WorkExperienceController {

    @Autowired
    private final WorkExperienceService workExperienceService;
    @PostMapping
    public ResponseEntity<WorkExperience> createWorkExperience(@Valid @RequestBody WorkExperienceDto workExperienceDto) {

        try {
            WorkExperience response = workExperienceService.createWorkExperience(workExperienceDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkExperience> getWorkExperienceById(@PathVariable("id") String id){
        try {
            WorkExperience response = workExperienceService.getWorkExperienceById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<WorkExperience>> getAllWorkExperiences(){
        try {
            List<WorkExperience> response = workExperienceService.getAllWorkExperience();
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WorkExperience> updateWorkExperience(@PathVariable("id") String id,@Valid @RequestBody WorkExperienceDto workExperienceDto){
        try {
            WorkExperience response = workExperienceService.updateWorkExperience(workExperienceDto,id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkExperience> deleteWorkExperienceById(@PathVariable("id") String id){
        try {
            WorkExperience response = workExperienceService.deleteWorkExperience(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
