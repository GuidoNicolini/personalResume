package com.cvpersonal.cvpersonal.dtos.request;

import com.cvpersonal.cvpersonal.enums.SocialMediaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SocialMediaDto {
    @NotBlank
    private SocialMediaEnum name;
    @NotBlank
    private String link;
    private String logo;
}
