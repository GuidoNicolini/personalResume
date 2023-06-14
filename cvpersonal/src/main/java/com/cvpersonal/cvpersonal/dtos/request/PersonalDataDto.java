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
public class PersonalDataDto {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private GregorianCalendar dateOfBirth;
    @NotBlank
    private String state;
    @NotBlank
    private String city;

    @NotBlank
    private String idPersonalInformation;
}
