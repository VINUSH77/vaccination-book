package com.vaxinbook.vaccinationbook.controller;

import com.vaxinbook.vaccinationbook.dao.SlotBookInput;
import com.vaxinbook.vaccinationbook.dao.entity.SlotBook;
import com.vaxinbook.vaccinationbook.service.SlotBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-slot")
public class SlotBookController {

    @Autowired
    private SlotBookService slotBookService;

    @PostMapping
    ResponseEntity<SlotBook> bookSlot(@RequestBody SlotBookInput slot){
        return new ResponseEntity<>(slotBookService.bookSlot(slot), HttpStatus.CREATED);
    }

}
