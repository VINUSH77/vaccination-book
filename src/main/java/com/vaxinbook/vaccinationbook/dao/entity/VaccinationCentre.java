package com.vaxinbook.vaccinationbook.dao.entity;

import com.vaxinbook.vaccinationbook.dao.VaccineJsonConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
public class VaccinationCentre {

    @Id
    @GeneratedValue
    private int id;

    private String city;

    private String District;

    private String state;

    private int pinCode;

    @Convert(converter = VaccineJsonConverter.class)
    private Map<String, Integer> vaccine;

    @OneToMany
    private List<SlotBook> slot;

}
