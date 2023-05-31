package com.vaxinbook.vaccinationbook.service;

import com.vaxinbook.vaccinationbook.dao.LoggedUser;
import com.vaxinbook.vaccinationbook.dao.Role;
import com.vaxinbook.vaccinationbook.dao.entity.VaccinationCentre;
import com.vaxinbook.vaccinationbook.exception.InvalidUser;
import com.vaxinbook.vaccinationbook.exception.NotFound;
import com.vaxinbook.vaccinationbook.repository.VaccinationCentreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VaccinationCentreServiceImpl implements VaccinationCentreService {

    @Autowired
    private VaccinationCentreRepo vaccinationCentreRepo;

    @Override
    public VaccinationCentre addVaccinationCentre(VaccinationCentre vaccinationCentre) {
        if (Objects.isNull(LoggedUser.currentUser))
            throw new InvalidUser("Please Login");
        if(!LoggedUser.currentUser.getRole().equals(Role.ADMIN))
            throw new InvalidUser("Logged in user is not allowed to add vaccination centre");
        return vaccinationCentreRepo.save(vaccinationCentre);

    }

    @Override
    public List<VaccinationCentre> getAllVaccinationCentre() {
        return vaccinationCentreRepo.findAll();
    }

    @Override
    public VaccinationCentre getVaccinationCentreById(Integer id) {
        return vaccinationCentreRepo.findById(id).orElseThrow(()->new NotFound("Vaccination centre not found"));
    }
}
