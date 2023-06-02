package com.cvpersonal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "personal_information")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE tool SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class PersonalInformation {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private ContactInformation contactInformation;
    private PersonalData personalData;
    private SocialMedia socialMedia;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "is_delete")
    private Boolean isDelete;
}
