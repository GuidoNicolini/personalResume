package com.cvpersonal.cvpersonal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity(name = "contact_information")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE contact_information SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class ContactInformation {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String mail;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "is_delete")
    private Boolean isDelete = Boolean.FALSE;
    @OneToOne(mappedBy = "contactInformation")
    private PersonalInformation personalInformation;
}
