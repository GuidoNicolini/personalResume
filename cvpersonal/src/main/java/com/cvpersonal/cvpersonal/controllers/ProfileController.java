package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.ProfileDto;
import com.cvpersonal.cvpersonal.models.Profile;
import com.cvpersonal.cvpersonal.services.interfaces.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/profile")
@CrossOrigin("*")
public class ProfileController {

    @Autowired
    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@Valid @RequestBody ProfileDto profileDto) {

        try {
            Profile response = profileService.createProfile(profileDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") String id) {
        try {
            Profile response = profileService.getProfileById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable("id") String id, @Valid @RequestBody ProfileDto profileDto) {
        try {
            Profile response = profileService.updateProfile(profileDto, id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Profile> deleteProfileById(@PathVariable("id") String id) {
        try {
            Profile response = profileService.deleteProfile(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}