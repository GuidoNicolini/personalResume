package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.ContactInformationDto;
import com.cvpersonal.cvpersonal.models.ContactInformation;
import com.cvpersonal.cvpersonal.services.interfaces.ContactInformationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/contactinformation")
public class ContactInformationController {

    @Autowired
    private final ContactInformationService contactInformationService;
    @PostMapping
    public ResponseEntity<ContactInformation> createContactInformation(@Valid @RequestBody ContactInformationDto contactInformationDto) {

        try {
            ContactInformation response = contactInformationService.createContactInformation(contactInformationDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactInformation> getContactInformationById(@PathVariable("id") String id){
        try {
            ContactInformation response = contactInformationService.getContactInformationById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ContactInformation> updateContactInformation(@PathVariable("id") String id,@Valid @RequestBody ContactInformationDto contactInformationDto){
        try {
            ContactInformation response = contactInformationService.updateContactInformation(contactInformationDto,id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContactInformation> deleteContactInformationById(@PathVariable("id") String id){
        try {
            ContactInformation response = contactInformationService.deleteContactInformation(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
