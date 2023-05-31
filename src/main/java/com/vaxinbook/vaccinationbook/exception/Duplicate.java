package com.vaxinbook.vaccinationbook.exception;

public class Duplicate extends RuntimeException{
    public Duplicate(String message) {
        super(message);
    }
}
