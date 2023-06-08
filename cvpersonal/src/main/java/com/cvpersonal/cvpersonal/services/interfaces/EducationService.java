package com.cvpersonal.cvpersonal.services.interfaces;



import com.cvpersonal.cvpersonal.dtos.request.EducationDto;
import com.cvpersonal.cvpersonal.models.Education;

import java.util.List;

public interface EducationService {
    Education createEducation(EducationDto educationDto);
    Education getEducationById(String id);
    List<Education> getAllEducation();
    Education updateEducation(EducationDto educationDto, String id);

    Education deleteEducation(String id);
}
