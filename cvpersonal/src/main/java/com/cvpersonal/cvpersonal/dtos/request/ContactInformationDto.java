package com.cvpersonal.cvpersonal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ContactInformationDto {
    @NotBlank
    private String mail;
    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String idPersonalInformation;
}
