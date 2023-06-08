package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.EducationDto;
import com.cvpersonal.cvpersonal.models.Education;
import com.cvpersonal.cvpersonal.repositories.EducationRepository;
import com.cvpersonal.cvpersonal.services.interfaces.EducationService;
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
public class EducationServiceImpl implements EducationService {

    private final ModelMapper modelMapper;
    @Autowired
    private EducationRepository repository;

    @Autowired
    private Verifier verifier;
    @Override
    @Transactional
    public Education createEducation(EducationDto educationDto) {
        Education education = modelMapper.map(educationDto,Education.class);

        try {
            return repository.save(education);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create education", e);
        }
    }

    @Override
    @Transactional
    public Education getEducationById(String id) {
        verifier.IdVerification(id);

        Optional<Education> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Education not found for ID: " + id));
    }

    @Override
    @Transactional
    public List<Education> getAllEducation() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Education updateEducation(EducationDto educationDto, String id) {
        verifier.IdVerification(id);

        Education answer = getEducation(id);

        modelMapper.map(educationDto,answer);

        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update education", e);
        }
    }

    @Override
    @Transactional
    public Education deleteEducation(String id) {
        verifier.IdVerification(id);

        Education answer = getEducation(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete education", e);
        }
    }

    private Education getEducation(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Education not found for ID: " + id));
    }
}
