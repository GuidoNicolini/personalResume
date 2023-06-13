package com.cvpersonal.cvpersonal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Table(name = "personal_data")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE personal_data SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class PersonalData {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private GregorianCalendar dateOfBirth;
    private String state;
    private String city;
    @Column(name = "is_delete")
    private Boolean isDelete = Boolean.FALSE;
    @OneToOne(mappedBy = "personalData")
    private PersonalInformation personalInformation;
}
