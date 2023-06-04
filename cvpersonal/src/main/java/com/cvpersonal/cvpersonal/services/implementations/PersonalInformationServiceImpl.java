package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.PersonalInformationDto;
import com.cvpersonal.cvpersonal.models.PersonalInformation;
import com.cvpersonal.cvpersonal.repositories.PersonalInformationRepository;
import com.cvpersonal.cvpersonal.services.interfaces.PersonalInformationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonalInformationServiceImpl implements PersonalInformationService {

    private final ModelMapper modelMapper;
    @Autowired
    private PersonalInformationRepository repository;
    @Override
    public PersonalInformation createPersonalInformation(PersonalInformationDto personalInformationDto) {
        return null;
    }

    @Override
    public PersonalInformation getPersonalInformationById(String id) {
        return null;
    }

    @Override
    public PersonalInformation updatePersonalInformation(PersonalInformationDto personalInformationDto, String id) {
        return null;
    }

    @Override
    public PersonalInformation deletePersonalInformation(String id) {
        return null;
    }
}
