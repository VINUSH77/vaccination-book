package com.vaxinbook.vaccinationbook.repository;

import com.vaxinbook.vaccinationbook.dao.entity.SlotBook;
import com.vaxinbook.vaccinationbook.dao.entity.User;
import com.vaxinbook.vaccinationbook.dao.entity.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SlotBookRepo extends JpaRepository<SlotBook, Integer> {
    SlotBook findByUserEquals(User user);
    List<SlotBook> findByVaccinationCentreEqualsAndDateEquals(VaccinationCentre vaccinationCentre, Date date);
}
