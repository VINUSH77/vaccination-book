package com.vaxinbook.vaccinationbook.service;

import com.vaxinbook.vaccinationbook.dao.SlotBookInput;
import com.vaxinbook.vaccinationbook.dao.entity.SlotBook;
import com.vaxinbook.vaccinationbook.dao.entity.User;
import com.vaxinbook.vaccinationbook.dao.entity.VaccinationCentre;
import com.vaxinbook.vaccinationbook.exception.Duplicate;
import com.vaxinbook.vaccinationbook.exception.FullSlot;
import com.vaxinbook.vaccinationbook.repository.SlotBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SlotBookServiceImpl implements SlotBookService{

    @Autowired
    private UserService userService;
    @Autowired
    private VaccinationCentreService vaccinationCentreService;

    @Autowired
    private SlotBookRepo slotBookRepo;

    @Override
    public SlotBook bookSlot(SlotBookInput slot) {
        User user = userService.getUserById(slot.getUser());
        VaccinationCentre vaccinationCentre = vaccinationCentreService.getVaccinationCentreById(slot.getVaccinationCentre());
        SlotBook slot1 = slotBookRepo.findByUserEquals(user);
        if (Objects.nonNull(slot1))
            throw new Duplicate("This user already booked the slot");
        List<SlotBook> slots = slotBookRepo.findByVaccinationCentreEqualsAndDateEquals(vaccinationCentre, slot.getDate());
        if(slots.size()>=10){
            throw new FullSlot("Slots are full for given date in this vaccination centre");
        }
        SlotBook newSlot = new SlotBook();
        newSlot.setUser(user);
        newSlot.setVaccinationCentre(vaccinationCentre);
        newSlot.setDate(slot.getDate());
        return slotBookRepo.save(newSlot);
    }
}
