package com.cvpersonal.cvpersonal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EducationDto {
    private String degree;
    private String description;
    private String establishment;
    private String logo;
}