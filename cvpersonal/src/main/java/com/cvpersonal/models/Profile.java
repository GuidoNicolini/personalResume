package com.cvpersonal.models;

import java.util.List;

public class Profile {
    private String id;
    private String name;
    private List<WorkExperience> workExperiences;
    private List<Education> educations;
    private List<Course>  courses;
    private List<Skill> skills;
    private String cv;

    private Boolean isDelete;
}
