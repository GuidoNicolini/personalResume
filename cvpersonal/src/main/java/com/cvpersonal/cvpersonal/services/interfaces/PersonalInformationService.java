package com.cvpersonal.cvpersonal.services.interfaces;

import com.cvpersonal.cvpersonal.dtos.request.PersonalInformationDto;
import com.cvpersonal.cvpersonal.models.PersonalInformation;

public interface PersonalInformationService {

    PersonalInformation createPersonalInformation(PersonalInformationDto personalInformationDto);
    PersonalInformation getPersonalInformationById(String id);
    PersonalInformation updatePersonalInformation(PersonalInformationDto personalInformationDto, String id);

    PersonalInformation deletePersonalInformation(String id);
}
