package com.cvpersonal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.GregorianCalendar;
@Table(name = "work_experiences")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE work_experiences SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class WorkExperience {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String id;
    @Column(name = "job_position")
    private String jobPosition;
    private String establishment;
    private String description;
    @Column(name = "initial_date")
    private GregorianCalendar initialDate;
    @Column(name = "end_date")
    private GregorianCalendar endDate;
    private String logo;
    @Column(name = "is_delete")
    private Boolean isDelete;
}
