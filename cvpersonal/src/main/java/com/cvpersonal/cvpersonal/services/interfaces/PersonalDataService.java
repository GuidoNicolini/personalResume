package com.cvpersonal.cvpersonal.services.interfaces;


import com.cvpersonal.cvpersonal.dtos.request.PersonalDataDto;
import com.cvpersonal.cvpersonal.models.PersonalData;

import java.util.List;

public interface PersonalDataService {
    PersonalData createPersonalData(PersonalDataDto personalDataDto);
    PersonalData getPersonalDataById(String id);
    PersonalData updatePersonalData(PersonalDataDto personalDataDto, String id);

    PersonalData deletePersonalData(String id);
}
