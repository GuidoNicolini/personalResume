package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.SocialMediaDto;
import com.cvpersonal.cvpersonal.models.SocialMedia;
import com.cvpersonal.cvpersonal.services.interfaces.SocialMediaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/socialmedia")
@CrossOrigin("*")
public class SocialMediaController {

    @Autowired
    private final SocialMediaService socialMediaService;
    @PostMapping
    public ResponseEntity<SocialMedia> createSocialMedia(@Valid @RequestBody SocialMediaDto socialMediaDto) {

        try {
            SocialMedia response = socialMediaService.createSocialMedia(socialMediaDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialMedia> getSocialMediaById(@PathVariable("id") String id){
        try {
            SocialMedia response = socialMediaService.getSocialMediaById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<SocialMedia>> getAllSocialMedias(){
        try {
            List<SocialMedia> response = socialMediaService.getAllSocialMedia();
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SocialMedia> updateSocialMedia(@PathVariable("id") String id,@Valid @RequestBody SocialMediaDto socialMediaDto){
        try {
            SocialMedia response = socialMediaService.updateSocialMedia(socialMediaDto,id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SocialMedia> deleteSocialMediaById(@PathVariable("id") String id){
        try {
            SocialMedia response = socialMediaService.deleteSocialMedia(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
