package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.PersonalInformationDto;
import com.cvpersonal.cvpersonal.models.PersonalInformation;
import com.cvpersonal.cvpersonal.repositories.PersonalInformationRepository;
import com.cvpersonal.cvpersonal.services.interfaces.PersonalInformationService;
import com.cvpersonal.cvpersonal.utils.Verifier;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonalInformationServiceImpl implements PersonalInformationService {

    private final ModelMapper modelMapper;
    @Autowired
    private PersonalInformationRepository repository;

    @Autowired
    private Verifier verifier;
    @Override
    @Transactional
    public PersonalInformation createPersonalInformation(PersonalInformationDto personalInformationDto) {
        PersonalInformation personalInformation = modelMapper.map(personalInformationDto,PersonalInformation.class);

        try {
            return repository.save(personalInformation);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create personal information", e);
        }
    }

    @Override
    @Transactional
    public PersonalInformation getPersonalInformationById(String id) {
        verifier.IdVerification(id);

        Optional<PersonalInformation> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Personal information not found for ID: " + id));
    }

    @Override
    @Transactional
    public PersonalInformation updatePersonalInformation(PersonalInformationDto personalInformationDto, String id) {
        verifier.IdVerification(id);

        PersonalInformation answer = getPersonalInformation(id);

        modelMapper.map(personalInformationDto,answer);

        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update personal information", e);
        }
    }

    @Override
    @Transactional
    public PersonalInformation deletePersonalInformation(String id) {
        verifier.IdVerification(id);

        PersonalInformation answer = getPersonalInformation(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete personal information", e);
        }
    }

    private PersonalInformation getPersonalInformation(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Personal information not found for ID: " + id));
    }
}
