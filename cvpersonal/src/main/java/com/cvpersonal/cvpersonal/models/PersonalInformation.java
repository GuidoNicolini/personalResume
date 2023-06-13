package com.cvpersonal.cvpersonal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Table(name = "personal_information")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE personal_information SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class PersonalInformation {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_information_id")
    private ContactInformation contactInformation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_id")
    private PersonalData personalData;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "social_media_id")
    private SocialMedia socialMedia;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "is_delete")
    private Boolean isDelete = Boolean.FALSE;
}
