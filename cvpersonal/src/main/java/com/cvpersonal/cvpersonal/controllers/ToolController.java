package com.cvpersonal.cvpersonal.controllers;

import com.cvpersonal.cvpersonal.dtos.request.ToolDto;
import com.cvpersonal.cvpersonal.models.Tool;
import com.cvpersonal.cvpersonal.services.interfaces.ToolService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tool")
@CrossOrigin("*")
public class ToolController {

    @Autowired
    private final ToolService toolService;
    @PostMapping
    public ResponseEntity<Tool> createTool(@Valid @RequestBody ToolDto toolDto) {

        try {
            Tool response = toolService.createTool(toolDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tool> getToolById(@PathVariable("id") String id){
        try {
            Tool response = toolService.getToolById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tool>> getAllTools(){
        try {
            List<Tool> response = toolService.getAllTool();
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Tool> updateTool(@PathVariable("id") String id,@Valid @RequestBody ToolDto toolDto){
        try {
            Tool response = toolService.updateTool(toolDto,id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tool> deleteToolById(@PathVariable("id") String id){
        try {
            Tool response = toolService.deleteTool(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
