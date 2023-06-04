package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.ToolDto;
import com.cvpersonal.cvpersonal.models.Tool;
import com.cvpersonal.cvpersonal.repositories.ToolRepository;
import com.cvpersonal.cvpersonal.services.interfaces.ToolService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ToolServiceImpl implements ToolService {
    private final ModelMapper modelMapper;
    @Autowired
    private ToolRepository toolRepository;

    @Override
    public Tool createTool(ToolDto toolDto) {
        return null;
    }

    @Override
    public Tool getToolById(String id) {
        return null;
    }

    @Override
    public List<Tool> getAllTool() {
        return null;
    }

    @Override
    public Tool updateTool(ToolDto toolDto, String id) {
        return null;
    }

    @Override
    public Tool deleteTool(String id) {
        return null;
    }
}
