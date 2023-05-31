package com.vaxinbook.vaccinationbook.exception;

public class FullSlot extends RuntimeException{
    public FullSlot(String message) {
        super(message);
    }
}
