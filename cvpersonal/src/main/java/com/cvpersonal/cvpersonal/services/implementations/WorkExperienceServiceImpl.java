package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.WorkExperienceDto;
import com.cvpersonal.cvpersonal.models.WorkExperience;
import com.cvpersonal.cvpersonal.repositories.WorkExperienceRepository;
import com.cvpersonal.cvpersonal.services.interfaces.WorkExperienceService;
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
public class WorkExperienceServiceImpl implements WorkExperienceService {

    private final ModelMapper modelMapper;
    @Autowired
    private WorkExperienceRepository repository;

    @Autowired
    private Verifier verifier;

    @Override
    @Transactional
    public WorkExperience createWorkExperience(WorkExperienceDto workExperienceDto) {

        WorkExperience workExperience = modelMapper.map(workExperienceDto,WorkExperience.class);

        try {
            return repository.save(workExperience);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create work experience", e);
        }
    }

    @Override
    @Transactional
    public WorkExperience getWorkExperienceById(String id) {
        verifier.IdVerification(id);

        Optional<WorkExperience> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Work experience not found for ID: " + id));
    }

    @Override
    @Transactional
    public List<WorkExperience> getAllWorkExperience() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public WorkExperience updateWorkExperience(WorkExperienceDto workExperienceDto, String id) {
        verifier.IdVerification(id);

        WorkExperience answer = getWorkExperience(id);

        modelMapper.map(workExperienceDto,answer);

        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update work experience", e);
        }
    }

    @Override
    @Transactional
    public WorkExperience deleteWorkExperience(String id) {
        verifier.IdVerification(id);

        WorkExperience answer = getWorkExperience(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete work experience", e);
        }
    }

    private WorkExperience getWorkExperience(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Work experience not found for ID: " + id));
    }
}
