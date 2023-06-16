package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.SkillDto;
import com.cvpersonal.cvpersonal.models.Skill;
import com.cvpersonal.cvpersonal.services.interfaces.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/skill")
@CrossOrigin("*")
public class SkillController {

    @Autowired
    private final SkillService skillService;
    @PostMapping
    public ResponseEntity<Skill> createSkill(@Valid @RequestBody SkillDto skillDto) {

        try {
            Skill response = skillService.createSkill(skillDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id") String id){
        try {
            Skill response = skillService.getSkillById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skill>> getAllSkills(){
        try {
            List<Skill> response = skillService.getAllSkill();
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable("id") String id,@Valid @RequestBody SkillDto skillDto){
        try {
            Skill response = skillService.updateSkill(skillDto,id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Skill> deleteSkillById(@PathVariable("id") String id){
        try {
            Skill response = skillService.deleteSkill(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
