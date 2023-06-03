package com.cvpersonal.cvpersonal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
@Table(name = "profiles")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE profiles SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class Profile {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private List<WorkExperience> workExperiences;
    private List<Education> educations;
    private List<Course>  courses;
    private List<Skill> skills;
    private String cv;
    @Column(name = "is_delete")
    private Boolean isDelete;
}
