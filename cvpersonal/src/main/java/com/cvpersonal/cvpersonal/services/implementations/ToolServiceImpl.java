package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.ToolDto;
import com.cvpersonal.cvpersonal.models.Tool;
import com.cvpersonal.cvpersonal.repositories.ToolRepository;
import com.cvpersonal.cvpersonal.services.interfaces.ToolService;
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
public class ToolServiceImpl implements ToolService {
    private final ModelMapper modelMapper;
    @Autowired
    private ToolRepository repository;

    @Autowired
    private Verifier verifier;

    @Override
    @Transactional
    public Tool createTool(ToolDto toolDto) {

        Tool tool = modelMapper.map(toolDto,Tool.class);

        try {
            return repository.save(tool);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create tool", e);
        }
        
    }

    @Override
    @Transactional
    public Tool getToolById(String id) {
        verifier.IdVerification(id);

        Optional<Tool> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Tool not found for ID: " + id));
    }

    @Override
    @Transactional
    public List<Tool> getAllTool() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Tool updateTool(ToolDto toolDto, String id) {
        verifier.IdVerification(id);

        Tool answer = getTool(id);

        modelMapper.map(toolDto,answer);

        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update tool", e);
        }
    }

    @Override
    @Transactional
    public Tool deleteTool(String id) {
        verifier.IdVerification(id);

        Tool answer = getTool(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete tool", e);
        }
    }

    private Tool getTool(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tool not found for ID: " + id));
    }
}
