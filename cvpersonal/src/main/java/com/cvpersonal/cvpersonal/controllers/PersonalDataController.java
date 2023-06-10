package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.PersonalDataDto;
import com.cvpersonal.cvpersonal.models.PersonalData;
import com.cvpersonal.cvpersonal.services.interfaces.PersonalDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/personaldata")
public class PersonalDataController {

    @Autowired
    private final PersonalDataService personalDataService;
    @PostMapping
    public ResponseEntity<PersonalData> createPersonalData(@Valid @RequestBody PersonalDataDto personalDataDto) {

        try {
            PersonalData response = personalDataService.createPersonalData(personalDataDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalData> getPersonalDataById(@PathVariable("id") String id){
        try {
            PersonalData response = personalDataService.getPersonalDataById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

    @PatchMapping("/{id}")
    public ResponseEntity<PersonalData> updatePersonalData(@PathVariable("id") String id,@Valid @RequestBody PersonalDataDto personalDataDto){
        try {
            PersonalData response = personalDataService.updatePersonalData(personalDataDto,id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonalData> deletePersonalDataById(@PathVariable("id") String id){
        try {
            PersonalData response = personalDataService.deletePersonalData(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
