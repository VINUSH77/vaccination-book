package com.vaxinbook.vaccinationbook.dao;

import lombok.Data;

import java.util.Date;

@Data
public class SlotBookInput {
    private Integer user;
    private Integer vaccinationCentre;
    private Date date;
}
