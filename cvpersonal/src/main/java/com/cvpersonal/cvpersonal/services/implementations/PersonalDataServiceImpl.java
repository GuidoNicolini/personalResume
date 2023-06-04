package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.PersonalDataDto;
import com.cvpersonal.cvpersonal.models.PersonalData;
import com.cvpersonal.cvpersonal.repositories.PersonalDataRepository;
import com.cvpersonal.cvpersonal.services.interfaces.PersonalDataService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonalDataServiceImpl implements PersonalDataService {

    private final ModelMapper modelMapper;
    @Autowired
    private PersonalDataRepository repository;
    @Override
    public PersonalData createPersonalData(PersonalDataDto personalDataDto) {
        return null;
    }

    @Override
    public PersonalData getPersonalDataById(String id) {
        return null;
    }

    @Override
    public PersonalData updatePersonalData(PersonalDataDto personalDataDto, String id) {
        return null;
    }

    @Override
    public PersonalData deletePersonalData(String id) {
        return null;
    }
}
