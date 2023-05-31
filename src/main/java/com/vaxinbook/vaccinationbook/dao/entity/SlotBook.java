package com.vaxinbook.vaccinationbook.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class SlotBook {

    @Id
    @GeneratedValue
    private int id;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vaccination_centre_id")
    private VaccinationCentre vaccinationCentre;
}
