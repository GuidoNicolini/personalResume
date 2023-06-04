package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.ContactInformationDto;
import com.cvpersonal.cvpersonal.models.ContactInformation;
import com.cvpersonal.cvpersonal.repositories.ContactInformationRepository;
import com.cvpersonal.cvpersonal.services.interfaces.ContactInformationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactInformationServiceImpl implements ContactInformationService {

    private final ModelMapper modelMapper;
    @Autowired
    private ContactInformationRepository repository;
    @Override
    public ContactInformation createContactInformation(ContactInformationDto contactInformationDto) {
        return null;
    }

    @Override
    public ContactInformation getContactInformationById(String id) {
        return null;
    }

    @Override
    public ContactInformation updateContactInformation(ContactInformationDto contactInformationDto, String id) {
        return null;
    }

    @Override
    public ContactInformation deleteContactInformation(String id) {
        return null;
    }
}
