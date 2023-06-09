package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.ContactInformationDto;
import com.cvpersonal.cvpersonal.models.ContactInformation;
import com.cvpersonal.cvpersonal.repositories.ContactInformationRepository;
import com.cvpersonal.cvpersonal.repositories.PersonalInformationRepository;
import com.cvpersonal.cvpersonal.services.interfaces.ContactInformationService;
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
public class ContactInformationServiceImpl implements ContactInformationService {

    private final ModelMapper modelMapper;
    @Autowired
    private ContactInformationRepository repository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;
    @Autowired
    private Verifier verifier;

    @Override
    @Transactional
    public ContactInformation createContactInformation(ContactInformationDto contactInformationDto) {

        if(personalInformationRepository.existsById(contactInformationDto.getIdPersonalInformation())) {
            try {
                ContactInformation contactInformation = modelMapper.map(contactInformationDto, ContactInformation.class);
                return repository.save(contactInformation);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create contact information", e);
            }
        }else{
            throw new IllegalArgumentException("Profile does not exist");
        }
    }

    @Override
    @Transactional
    public ContactInformation getContactInformationById(String id) {

        verifier.IdVerification(id);

        Optional<ContactInformation> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Contact information not found for ID: " + id));
    }



    @Override
    @Transactional
    public ContactInformation updateContactInformation(ContactInformationDto contactInformationDto, String id) {

        verifier.IdVerification(id);

        ContactInformation answer = getContactInformation(id);

        answer.setMail(contactInformationDto.getMail());
        answer.setPhoneNumber(contactInformationDto.getPhoneNumber());


        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update contact information", e);
        }
        
    }

    @Override
    @Transactional
    public ContactInformation deleteContactInformation(String id) {

        verifier.IdVerification(id);

        ContactInformation answer = getContactInformation(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete contact information", e);
        }
    }

    private ContactInformation getContactInformation(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contact information not found for ID: " + id));
    }

}
