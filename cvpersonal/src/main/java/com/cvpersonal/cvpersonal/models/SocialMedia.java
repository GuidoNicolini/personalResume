package com.cvpersonal.cvpersonal.models;

import com.cvpersonal.enums.SocialMediaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
@Table(name = "social_medias")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE social_medias SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class SocialMedia {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String link;
    private SocialMediaEnum name;
    private String logo;
    @Column(name = "is_delete")
    private Boolean isDelete;

    @OneToOne(mappedBy = "socialMedia")
    private PersonalInformation personalInformation;
}
