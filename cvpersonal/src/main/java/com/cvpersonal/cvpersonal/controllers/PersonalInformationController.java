package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.PersonalInformationDto;
import com.cvpersonal.cvpersonal.models.PersonalInformation;
import com.cvpersonal.cvpersonal.services.interfaces.PersonalInformationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/personalinformation")
public class PersonalInformationController {

    @Autowired
    private final PersonalInformationService personalInformationService;

    @PostMapping
    public ResponseEntity<PersonalInformation> createPersonalInformation(@Valid @RequestBody PersonalInformationDto personalInformationDto) {

        try {
            PersonalInformation response = personalInformationService.createPersonalInformation(personalInformationDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalInformation> getPersonalInformationById(@PathVariable("id") String id) {
        try {
            PersonalInformation response = personalInformationService.getPersonalInformationById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<PersonalInformation> updatePersonalInformation(@PathVariable("id") String id, @Valid @RequestBody PersonalInformationDto personalInformationDto) {
        try {
            PersonalInformation response = personalInformationService.updatePersonalInformation(personalInformationDto, id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonalInformation> deletePersonalInformationById(@PathVariable("id") String id) {
        try {
            PersonalInformation response = personalInformationService.deletePersonalInformation(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
