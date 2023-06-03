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
public class PersonalDataDto {
    private String name;
    private String lastName;
    private GregorianCalendar dateOfBirth;
    private String state;
    private String city;
}
