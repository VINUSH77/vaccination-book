package com.vaxinbook.vaccinationbook.controller;

import com.vaxinbook.vaccinationbook.dao.entity.VaccinationCentre;
import com.vaxinbook.vaccinationbook.service.VaccinationCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccinationCentre")
public class VaccinationCentreController {

    @Autowired
    private VaccinationCentreService vaccinationCentreService;

    @PostMapping
    ResponseEntity<VaccinationCentre> addVaccinationCentre(@RequestBody VaccinationCentre vaccinationCentre){
        return new ResponseEntity<>(vaccinationCentreService.addVaccinationCentre(vaccinationCentre), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<VaccinationCentre>> getAllVaccinationCentre(){
        return new ResponseEntity<>(vaccinationCentreService.getAllVaccinationCentre(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<VaccinationCentre> getVaccinationCentreById(@PathVariable Integer id){
        return new ResponseEntity<>(vaccinationCentreService.getVaccinationCentreById(id), HttpStatus.OK);
    }
}
