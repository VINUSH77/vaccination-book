package com.vaxinbook.vaccinationbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            Duplicate.class
    })
    ResponseEntity<Object> handleDuplicate(RuntimeException exception){

        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.CONFLICT.value(),
                        exception.getMessage(),
                        exception.getLocalizedMessage()),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler({
            NotFound.class
    })
    ResponseEntity<Object> handleNotFound(RuntimeException exception){
        return new ResponseEntity<>(
                new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                exception.getLocalizedMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            InvalidUser.class
    })
    ResponseEntity<Object> handleInvalid(RuntimeException exception){
        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.UNAUTHORIZED.value(),
                        exception.getMessage(),
                        exception.getLocalizedMessage()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({
            FullSlot.class
    })
    ResponseEntity<Object> handleFullSlot(RuntimeException exception){
        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.NOT_ACCEPTABLE.value(),
                        exception.getMessage(),
                        exception.getLocalizedMessage()),
                HttpStatus.NOT_ACCEPTABLE);
    }
}
