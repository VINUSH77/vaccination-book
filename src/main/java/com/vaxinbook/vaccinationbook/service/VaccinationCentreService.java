package com.vaxinbook.vaccinationbook.service;

import com.vaxinbook.vaccinationbook.dao.Vaccine;
import com.vaxinbook.vaccinationbook.dao.entity.VaccinationCentre;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VaccinationCentreService {
    VaccinationCentre addVaccinationCentre(VaccinationCentre vaccinationCentre);
    List<VaccinationCentre> getAllVaccinationCentre();
    VaccinationCentre getVaccinationCentreById(Integer id);
}
