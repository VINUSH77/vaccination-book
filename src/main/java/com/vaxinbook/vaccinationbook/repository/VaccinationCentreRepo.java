package com.vaxinbook.vaccinationbook.repository;

import com.vaxinbook.vaccinationbook.dao.entity.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCentreRepo extends JpaRepository<VaccinationCentre, Integer> {
}
