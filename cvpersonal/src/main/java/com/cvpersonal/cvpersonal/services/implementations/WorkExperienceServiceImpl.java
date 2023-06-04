package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.WorkExperienceDto;
import com.cvpersonal.cvpersonal.models.WorkExperience;
import com.cvpersonal.cvpersonal.repositories.WorkExperienceRepository;
import com.cvpersonal.cvpersonal.services.interfaces.WorkExperienceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkExperienceServiceImpl implements WorkExperienceService {

    private final ModelMapper modelMapper;
    @Autowired
    private WorkExperienceRepository repository;

    @Override
    public WorkExperience createWorkExperience(WorkExperienceDto workExperienceDto) {
        return null;
    }

    @Override
    public WorkExperience getWorkExperienceById(String id) {
        return null;
    }

    @Override
    public List<WorkExperience> getAllWorkExperience() {
        return null;
    }

    @Override
    public WorkExperience updateWorkExperience(WorkExperienceDto workExperienceDto, String id) {
        return null;
    }

    @Override
    public WorkExperience deleteWorkExperience(String id) {
        return null;
    }
}
