package com.cvpersonal.cvpersonal.dtos.request;

import com.cvpersonal.cvpersonal.enums.SocialMediaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SocialMediaDto {
    private String link;
    private SocialMediaEnum name;
    private String logo;
}
