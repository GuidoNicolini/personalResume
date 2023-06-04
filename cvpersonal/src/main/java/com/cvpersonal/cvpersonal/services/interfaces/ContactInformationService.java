package com.cvpersonal.cvpersonal.services.interfaces;

import com.cvpersonal.cvpersonal.dtos.request.ContactInformationDto;
import com.cvpersonal.cvpersonal.models.ContactInformation;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ContactInformationService {

    ContactInformation createContactInformation(ContactInformationDto contactInformationDto);
    ContactInformation getContactInformationById(String id);
    ContactInformation updateContactInformation(ContactInformationDto contactInformationDto,String id);

    ContactInformation deleteContactInformation(String id);

}
