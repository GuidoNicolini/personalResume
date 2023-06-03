package com.cvpersonal.cvpersonal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.GregorianCalendar;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WorkExperienceDto {
    private String jobPosition;
    private String establishment;
    private String description;
    private GregorianCalendar initialDate;
    private GregorianCalendar endDate;
    private String logo;
}
