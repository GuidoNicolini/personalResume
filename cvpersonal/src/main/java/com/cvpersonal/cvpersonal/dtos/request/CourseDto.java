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
public class CourseDto {
    private String name;
    private GregorianCalendar date;
    private String description;
    private String establishment;
    private String logo;
}
