package com.vaxinbook.vaccinationbook.service;

import com.vaxinbook.vaccinationbook.dao.SlotBookInput;
import com.vaxinbook.vaccinationbook.dao.entity.SlotBook;
import org.springframework.stereotype.Service;

public interface SlotBookService {
    SlotBook bookSlot(SlotBookInput slot);
}
