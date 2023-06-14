package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.PersonalDataDto;
import com.cvpersonal.cvpersonal.models.PersonalData;
import com.cvpersonal.cvpersonal.repositories.PersonalDataRepository;
import com.cvpersonal.cvpersonal.repositories.PersonalInformationRepository;
import com.cvpersonal.cvpersonal.services.interfaces.PersonalDataService;
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
public class PersonalDataServiceImpl implements PersonalDataService {

    private final ModelMapper modelMapper;
    @Autowired
    private PersonalDataRepository repository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @Autowired
    private Verifier verifier;
    @Override
    @Transactional
    public PersonalData createPersonalData(PersonalDataDto personalDataDto) {

        if(personalInformationRepository.existsById(personalDataDto.getIdPersonalInformation())) {
            try {
                PersonalData personalData = modelMapper.map(personalDataDto, PersonalData.class);
                return repository.save(personalData);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create personal data", e);
            }
        }else{
            throw new IllegalArgumentException("Profile does not exist");
        }
    }

    @Override
    @Transactional
    public PersonalData getPersonalDataById(String id) {
        verifier.IdVerification(id);

        Optional<PersonalData> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Personal data not found for ID: " + id));
    }

    @Override
    @Transactional
    public PersonalData updatePersonalData(PersonalDataDto personalDataDto, String id) {
        verifier.IdVerification(id);

        PersonalData answer = getPersonalData(id);

        modelMapper.map(personalDataDto,answer);

        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update personal data", e);
        }
    }

    @Override
    @Transactional
    public PersonalData deletePersonalData(String id) {
        verifier.IdVerification(id);

        PersonalData answer = getPersonalData(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete personal data", e);
        }
    }
    private PersonalData getPersonalData(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Personal data not found for ID: " + id));
    }
}
