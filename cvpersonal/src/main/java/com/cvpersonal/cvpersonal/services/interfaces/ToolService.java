package com.cvpersonal.cvpersonal.services.interfaces;


import com.cvpersonal.cvpersonal.dtos.request.ToolDto;
import com.cvpersonal.cvpersonal.models.Tool;

import java.util.List;

public interface ToolService {
    Tool createTool(ToolDto toolDto);
    Tool getToolById(String id);
    List<Tool> getAllTool();
    Tool updateTool(ToolDto toolDto, String id);

    Tool deleteTool(String id);
}
