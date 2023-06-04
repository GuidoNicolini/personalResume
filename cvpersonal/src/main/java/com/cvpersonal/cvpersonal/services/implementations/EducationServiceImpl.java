package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.EducationDto;
import com.cvpersonal.cvpersonal.models.Education;
import com.cvpersonal.cvpersonal.repositories.EducationRepository;
import com.cvpersonal.cvpersonal.services.interfaces.EducationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final ModelMapper modelMapper;
    @Autowired
    private EducationRepository repository;
    @Override
    public Education createEducation(EducationDto educationDto) {
        return null;
    }

    @Override
    public Education getEducationById(String id) {
        return null;
    }

    @Override
    public List<Education> getAllEducation() {
        return null;
    }

    @Override
    public Education updateEducation(EducationDto educationDto, String id) {
        return null;
    }

    @Override
    public Education deleteEducation(String id) {
        return null;
    }
}
