package com.cvpersonal.cvpersonal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.GregorianCalendar;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WorkExperienceDto {
    @NotBlank
    private String jobPosition;
    @NotBlank
    private String establishment;
    private String description;
    @NotBlank
    private GregorianCalendar initialDate;
    private GregorianCalendar endDate;
    private String logo;

    @NotBlank
    private String idProfile;
}
