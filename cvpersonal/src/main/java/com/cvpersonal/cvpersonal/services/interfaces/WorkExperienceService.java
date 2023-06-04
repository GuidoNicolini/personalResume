package com.cvpersonal.cvpersonal.services.interfaces;


import com.cvpersonal.cvpersonal.dtos.request.WorkExperienceDto;
import com.cvpersonal.cvpersonal.models.WorkExperience;

import java.util.List;

public interface WorkExperienceService {
    WorkExperience createWorkExperience(WorkExperienceDto workExperienceDto);
    WorkExperience getWorkExperienceById(String id);
    List<WorkExperience> getAllWorkExperience();
    WorkExperience updateWorkExperience(WorkExperienceDto workExperienceDto, String id);

    WorkExperience deleteWorkExperience(String id);
}
